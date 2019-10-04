package com.imooc.Service.impl;

import com.imooc.DTO.OrderDTO;
import com.imooc.DataObject.OrderDetail;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

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
        o1.setProductId("2");
        o1.setProductQuantity(3);
        orderDetailList.add(o1);
        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        log.info("[创建订单]result",result);
        System.out.println(result);

        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() throws Exception {
    }

    @Test
    public void find() throws Exception {
    }

    @Test
    public void cancel() throws Exception {
    }

    @Test
    public void finish() throws Exception {
    }

    @Test
    public void paid() throws Exception {
    }

}