package com.imooc.Service.impl;

import com.imooc.DTO.OrderDTO;
import com.imooc.DataObject.OrderDetail;
import com.imooc.DataObject.OrderMaster;
import com.imooc.DataObject.ProductInfo;
import com.imooc.Enum.ResultEnum;
import com.imooc.Exception.ReceiveException;
import com.imooc.Repository.OrderDetailRepository;
import com.imooc.Repository.OrderMasterRepository;
import com.imooc.Service.OrderService;
import com.imooc.utils.RandomUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by lxy on 2019/8/26.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    /**
     * 创建订单
     * @return
     */
    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        //订单创建时，订单号就应该创建
        String orderId= RandomUtil.getUniqueKey();
        BigDecimal orderAmount = new BigDecimal(0);
        // 查询商品
        for(OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            ProductInfo productInfo =productService.findOne(orderDetail.getProductId());
            if(productInfo == null) {
                throw new ReceiveException(ResultEnum.NOT_EXIST.getMessage());
            }
            // 计算订单总金额
            orderAmount = productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
            .add(orderAmount);
            // 订单详情写入订单详情表
            orderDetail.setDetailId(RandomUtil.getUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetailRepository.save(orderDetail);
        }

        // 写入订单主表
        OrderMaster orderMaster = new OrderMaster();

        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMasterRepository.save(orderMaster);

        return null;
    }
}
