package com.wechat.service;


import com.wechat.DTO.OrderDTO;

/**
 * 支付
 * Created by lxy on 2019/11/8.
 */
public interface PayService {

    void create(OrderDTO orderDTO);
}
