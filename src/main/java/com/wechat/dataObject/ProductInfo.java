package com.wechat.dataObject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wechat.Enum.ProductStatusEnum;
import com.wechat.utils.EnmuUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by lxy on 2019/7/17.
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo {
    /**
     * 主键Id
     */
    @Id
    private String productId;
    /**
     * 商品名称
     */
    private String productName;
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
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 通过code获取枚举
     * @return
     */
    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum() {
        ProductStatusEnum productStatusEnum = EnmuUtil.getByCode(productStatus, ProductStatusEnum.class);
        return productStatusEnum;
    }
}
