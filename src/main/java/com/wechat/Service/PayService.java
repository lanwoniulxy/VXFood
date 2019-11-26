package com.wechat.service;


import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;
import com.wechat.DTO.OrderDTO;

/**
 * 微信支付Service
 * Created by lxy on 2019/11/8.
 */
public interface PayService {

    PayResponse create(OrderDTO orderDTO);
    PayResponse notify(String notifyData);
    RefundResponse refund(OrderDTO orderDTO);
}
