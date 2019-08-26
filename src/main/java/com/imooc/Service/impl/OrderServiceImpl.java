package com.imooc.Service.impl;

import com.imooc.DTO.OrderDTO;
import com.imooc.DataObject.OrderDetail;
import com.imooc.DataObject.OrderMaster;
import com.imooc.Repository.OrderDetailRepository;
import com.imooc.Repository.OrderMasterRepository;
import com.imooc.Service.OrderService;
import com.imooc.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lxy on 2019/8/26.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMasterRepository orderMasterRepository;

    /**
     * 创建订单
     * @return
     */
    @Override
    public OrderDTO create() {
        OrderDTO orderDTO = new OrderDTO();
        OrderMaster orderMaster = new OrderMaster();

        orderMaster.setOrderId(RandomUtil.generate());
        orderMaster.setBuyerName(orderDTO.getBuyerName());
        orderMaster.setBuyerAddress(orderDTO.getBuyerAddress());
        orderMaster.setBuyerPhone(orderDTO.getBuyerPhone());
        orderMaster.setBuyerOpenid(orderDTO.getBuyerOpenid());


        for(OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            orderDetail.getProductId();
            orderDetail.getProductQuantity();
        }

        //orderMaster.setOrderAmount();
        orderMasterRepository.save(orderMaster);

        return null;
    }
}
