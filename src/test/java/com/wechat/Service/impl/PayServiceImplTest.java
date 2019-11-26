package com.wechat.Service.impl;

import com.wechat.DTO.OrderDTO;
import com.wechat.service.impl.OrderServiceImpl;
import com.wechat.service.impl.PayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by lxy on 2019/11/9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {
    @Autowired
    private PayServiceImpl payService;
    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void create() throws Exception {
        OrderDTO orderDTO = orderService.findOne("1570776370359917213");
        payService.create(orderDTO);
    }

}