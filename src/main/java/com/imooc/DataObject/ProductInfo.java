package com.imooc.DataObject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by lxy on 2019/7/17.
 */
@Entity
@Data
public class ProductInfo {
    /**
     * 主键Id
     */
    @Id
    private String productId;
    /**
     * 商品名称
     */
    private  String productName;
    /**
     * 单价
     */
    private BigDecimal productPrice;
    /**
     * 库存
     */
    private Integer productStock;
    /**
     * 描述
     */
    private String productDescription;
    /**
     * 小图
     */
    private String productIcon;
    /**
     * 商品状态: 0正常 1下架
     */
    private Integer productStatus;
    /**
     * 类目编号
     */
    private Integer categoryType;

}
