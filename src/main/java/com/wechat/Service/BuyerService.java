package com.wechat.service;


import com.wechat.DTO.OrderDTO;

/**
 * 买家端Service
 * Created by lxy on 2019/10/11.
 */
public interface BuyerService {

    //查找一个订单
    OrderDTO findOrderOne(String openid, String OrderId);

    //关闭订单
    OrderDTO cancel(String openid, String OrderId);
}
