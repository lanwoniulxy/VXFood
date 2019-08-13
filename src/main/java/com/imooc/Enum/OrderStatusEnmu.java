package com.imooc.Enum;

import lombok.Getter;


/**
 * Created by lxy on 2019/8/1.
 */
@Getter
public enum OrderStatusEnmu {
    NEW(0,"新下单"),
    FINISH(1,"已完成"),
    CANCEL(2, "已取消"),
    ;

    private Integer code;
    private String msg;

    OrderStatusEnmu(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
