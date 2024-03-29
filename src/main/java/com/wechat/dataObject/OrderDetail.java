package com.wechat.dataObject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by lxy on 2019/8/1.
 */
@Entity
@Data
public class OrderDetail {
    /**
     * 订单详情id
     */
    @Id
    private String detailId;
    /**
     * 订单id
     */
    private String orderId;
    /**
     * 商品id
     */
    private String productId;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 当前价格
     */
    private BigDecimal productPrice;
    /**
     * 数量
     */
    private Integer productQuantity;
    /**
     * 小图
     */
    private String productIcon;

}
