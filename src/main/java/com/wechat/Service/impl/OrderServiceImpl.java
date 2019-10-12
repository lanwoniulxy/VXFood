package com.wechat.Service.impl;

import com.wechat.Converter.OrderMaster2OrderDTOConverter;
import com.wechat.DTO.CartDTO;
import com.wechat.DTO.OrderDTO;
import com.wechat.DataObject.OrderDetail;
import com.wechat.DataObject.OrderMaster;
import com.wechat.DataObject.ProductInfo;
import com.wechat.Enum.OrderStatusEnum;
import com.wechat.Enum.PayStatusEnum;
import com.wechat.Enum.ResultEnum;
import com.wechat.Exception.SellException;
import com.wechat.Repository.OrderDetailRepository;
import com.wechat.Repository.OrderMasterRepository;
import com.wechat.Service.OrderService;
import com.wechat.Service.ProductService;
import com.wechat.utils.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lxy on 2019/8/26.
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    /**
     * 创建订单
     * @return
     */
    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        //订单创建时，订单号就应该创建
        String orderId= RandomUtil.getUniqueKey();
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        // 1.查询商品(数量，价格)
        for(OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            ProductInfo productInfo =productService.findOne(orderDetail.getProductId());
            if(productInfo == null) {
                throw new SellException(ResultEnum.NOT_EXIST.getMessage());
            }
            // 2.计算订单总金额
            orderAmount = productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);

            // 订单详情写入订单详情表
            orderDetail.setDetailId(RandomUtil.getUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetailRepository.save(orderDetail);
        }

        // 3.写入订单主表
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        orderDTO.setOrderAmount(orderAmount);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);

        //4.扣库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream()
                .map(e -> new CartDTO(e.getProductId(),e.getProductQuantity()))
                .collect(Collectors.toList());

        productService.decreaseStock(cartDTOList);



        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {

        OrderMaster orderMaster = orderMasterRepository.findOne(orderId);
        if (orderMaster == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST.getMessage());
        }

        List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId(orderId);
        if (CollectionUtils.isEmpty(orderDetailList)) {
            throw new SellException(ResultEnum.ORDERDETAIL_NOT_EXIST.getMessage());
        }

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }


    @Override
    public Page<OrderDTO> findList(String openId, Pageable pageable) {
        Page<OrderMaster> orderMasterPage = orderMasterRepository.findByBuyerOpenid(openId, pageable);
        List<OrderDTO> orderDTOList = OrderMaster2OrderDTOConverter.conver(orderMasterPage.getContent());
        return new PageImpl<OrderDTO>(orderDTOList, pageable, orderMasterPage.getTotalElements());
    }

    @Override
    @Transactional
    public OrderDTO cancel(OrderDTO orderDTO) {
        //1.判断订单状态
        OrderMaster orderMaster = new OrderMaster();
        if(!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            log.error("【取消订单】订单状态不正确,orderDTO.getOrderStatus={}",orderDTO.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR.getMessage());
        }
        //2.更改订单状态
        orderDTO.setOrderStatus(OrderStatusEnum.CANCEL.getCode());
        BeanUtils.copyProperties(orderDTO, orderMaster);
        OrderMaster updateResult = orderMasterRepository.save(orderMaster);
        if (updateResult == null) {
            log.error("【取消订单】修改订单失败,orderMaster={}",orderMaster);
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL.getMessage());
        }
        //3.返回库存
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【取消订单】订单中无订单详情,orderDTO={}",orderDTO);
            throw new SellException(ResultEnum.ORDER_DETAIL_EMPTY.getMessage());
        }
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream()
                .map(e -> new CartDTO(e.getProductId(),e.getProductQuantity()))
                .collect(Collectors.toList());
        productService.increaseStock(cartDTOList);

        //4.退款
        if (orderDTO.getPayStatus().equals(PayStatusEnum.SUCCESS.getCode())) {
            //TODO
        }

        return orderDTO;
    }

    @Override
    @Transactional
    public OrderDTO finish(OrderDTO orderDTO) {

        //判断订单状态
        if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            log.error("【完结订单】订单状态不正确,orderDTO.getgetOrderStatus={}",orderDTO.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR.getMessage());
        }
        //修改订单状态
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderStatus(OrderStatusEnum.FINISH.getCode());
        BeanUtils.copyProperties(orderDTO, orderMaster);
        OrderMaster updateResult = orderMasterRepository.save(orderMaster);
        if(updateResult == null) {
            log.error("【完结订单】修改订单状态失败，orderMaster={}",orderMaster);
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL.getMessage());
        }
        return orderDTO;
    }

    @Override
    @Transactional
    public OrderDTO paid(OrderDTO orderDTO) {
        //判断订单状态
        if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            log.error("【订单支付完成】订单状态不正确,orderDTO.getOrderStatus={}",orderDTO.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR.getMessage());
        }
        //判断支付状态
        if (!orderDTO.getPayStatus().equals(PayStatusEnum.WAIT.getCode())) {
            log.error("【订单支付完成】支付状态不正确,orderDTO.getPayStatus={}",orderDTO.getPayStatus());
            throw new SellException(ResultEnum.ORDER_PAY_STATUS_ERROR.getMessage());
        }

        //修改支付状态
        orderDTO.setPayStatus(PayStatusEnum.SUCCESS.getCode());
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        OrderMaster updateResult = orderMasterRepository.save(orderMaster);
        if (updateResult == null) {
            log.error("【订单支付完成】修改订单状态失败,orderMaster={}",orderMaster);
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL.getMessage());
        }
        return orderDTO;
    }
}
