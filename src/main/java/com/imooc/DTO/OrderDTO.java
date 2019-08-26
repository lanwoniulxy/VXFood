package com.imooc.DTO;

import com.imooc.DataObject.OrderDetail;
import lombok.Data;

import java.util.List;

/**
 * Created by EDZ on 2019/8/26.
 */
@Data
public class OrderDTO {
    /**
     * 订单ID.
     */
    private String orderId;
    /**
     * 买家名字
     */
    private String buyerName;
    /**
     * 买家电话
     */
    private String buyerPhone;
    /**
     * 买家地址
     */
    private String buyerAddress;
    /**
     * 买家微信openid
     */
    private String buyerOpenid;
    /**
     * 商品信息
     */
    private List<OrderDetail> OrderDetailList;
}
