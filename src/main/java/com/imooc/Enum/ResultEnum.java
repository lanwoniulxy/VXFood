package com.imooc.Enum;

import lombok.Getter;

/**
 * Created by EDZ on 2019/8/28.
 */
@Getter
public enum ResultEnum {
    NOT_EXIST(10,"商品信息为空"),
    PRODUCT_STOCK_ERROR(11,"商品库存不正确"),
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
