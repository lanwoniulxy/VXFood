package com.wechat.DTO;

import lombok.Data;

/**
 * Created by lxy on 2019/10/1.
 */
@Data
public class CartDTO {

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
    /**
     * 商品id
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;

}
