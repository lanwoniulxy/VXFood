package com.imooc.DTO;

import com.imooc.DataObject.OrderDetail;
import lombok.Data;

import java.util.Date;
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
     * 订单状态 默认为新下单
     */
    private Integer orderStatus;
    /**
     * 支付状态 默认为已支付
     */
    private Integer payStatus;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 商品信息
     */
    private List<OrderDetail> OrderDetailList;
}
