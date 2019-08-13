package com.imooc.DataObject;

import com.imooc.Enum.OrderStatusEnmu;
import com.imooc.Enum.PayStatusEnmu;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by lxy on 2019/8/1.
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    /**
     * 订单ID.
     */
    @Id
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
     * 订单总金额
     */
    private BigDecimal orderAmount;
    /**
     * 订单状态 默认为新下单
     */
    private Integer orderStatus = OrderStatusEnmu.NEW.getCode();
    /**
     * 支付状态 默认为已支付
     */
    private Integer payStatus = PayStatusEnmu.WAIT.getCode();
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;


}
