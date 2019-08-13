package com.imooc.Enum;

import lombok.Getter;

/**
 * Created by lxy on 2019/7/22.
 */
@Getter
public enum ProductStatusEnmu {
    UP(0,"在架"),
    DOWN(1,"下架")
    ;
    private Integer code;
    private String message;

    ProductStatusEnmu(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
