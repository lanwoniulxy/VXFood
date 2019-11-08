package com.wechat.controller;

import com.wechat.DTO.OrderDTO;
import com.wechat.Enum.ResultEnum;
import com.wechat.Exception.SellException;
import com.wechat.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by lxy on 2019/11/8.
 */
@Controller
@RequestMapping("/pay")
@Slf4j
public class PayController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/create")
    public void pay(@RequestParam("orderId") String orderId,
                    @RequestParam("returnUrl") String returnUrl) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        //配置
//        WxPayH5Config wxPayH5Config = new WxPayH5Config();
//        wxPayH5Config.setAppId();
//        wxPayH5Config.setAppSecret();
//        wxPayH5Config.setMchId();
//        wxPayH5Config.setMchKey();
//        wxPayH5Config.setNotifyUrl();
        //发起支付
    }
}
