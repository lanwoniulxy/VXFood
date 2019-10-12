package com.wechat.Service.impl;

import com.wechat.DTO.OrderDTO;
import com.wechat.DataObject.OrderDetail;
import com.wechat.Enum.OrderStatusEnum;
import com.wechat.Enum.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxy on 2019/10/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;
    private final String openid = "123456";
    @Test
    public void create() throws Exception {

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName("李新宇");
        orderDTO.setBuyerAddress("上海");
        orderDTO.setBuyerOpenid(openid);
        orderDTO.setBuyerPhone("18947197803");

        List<OrderDetail> orderDetailList = new ArrayList();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("5");
        o1.setProductQuantity(1000);
        orderDetailList.add(o1);
        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        log.info("[创建订单]result",result);
        System.out.println(result);

        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() throws Exception {
        OrderDTO result = orderService.findOne("1570255872451651095");
        log.info("查询单个订单,result={}",result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findList() throws Exception {
        Pageable request = new PageRequest(0,3);
        Page<OrderDTO> result = orderService.findList(openid, request);
        log.info("查询订单列表,result={}",result.getContent());
        Assert.assertNotEquals(0, result.getTotalElements());
    }

    @Test
    public void cancel() throws Exception {

        OrderDTO orderDTO = orderService.findOne("1570255872451651095");
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(), result.getOrderStatus());
    }

    @Test
    public void finish() throws Exception {

        OrderDTO orderDTO = orderService.findOne("1570255872451651095");
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISH.getCode(), result.getOrderStatus());
    }

    @Test
    public void paid() throws Exception {

        OrderDTO orderDTO = orderService.findOne("1570255872451651095");
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(), result.getPayStatus());
    }

}