package com.imooc.Enum;

import lombok.Getter;

/**
 * Created by lxy on 2019/8/1.
 */
@Getter
public enum PayStatusEnmu {
    WAIT(0, "等待支付"),
    SUCCESS(1,"支付成功"),

    ;

    private Integer code;
    private String msg;

    PayStatusEnmu(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
