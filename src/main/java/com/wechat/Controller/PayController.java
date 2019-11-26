package com.wechat.controller;

import com.lly835.bestpay.model.PayResponse;
import com.wechat.DTO.OrderDTO;
import com.wechat.Enum.ResultEnum;
import com.wechat.Exception.SellException;
import com.wechat.service.OrderService;
import com.wechat.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 微信支付模块
 * Created by lxy on 2019/11/8.
 */
@Controller
@RequestMapping("/pay")
@Slf4j
public class PayController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private PayService payService;

    /**
     * 微信支付创建预付单
     * @param orderId
     * @param returnUrl
     * @param map
     * @return
     */
    @GetMapping("/create")
    public ModelAndView pay(@RequestParam("orderId") String orderId,
                            @RequestParam("returnUrl") String returnUrl,
                            Map<String, Object> map) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        PayResponse payResponse = payService.create(orderDTO);
        map.put("payResponse", payResponse);
        map.put("orderId", orderId);
        return new ModelAndView("pay/create", map);
    }

    /**
     * 微信支付异步通知回调地址
     * @param notifyData
     * @return
     */
    @PostMapping("/notify")
    public ModelAndView notify (@RequestBody String notifyData) {

        PayResponse payResponse = payService.notify(notifyData);
        log.info("【微信通知支付结果】payResponse={}",payResponse);
        //返回给微信处理结果
        return new ModelAndView("pay/success");
    }
}
