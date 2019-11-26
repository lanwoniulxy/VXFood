package com.wechat.Enum;

import lombok.Getter;


/**
 * Created by lxy on 2019/8/1.
 */
@Getter
public enum OrderStatusEnum implements CodeEnum{
    NEW(0, "新订单"),
    FINISH(1, "已完成"),
    CANCEL(2, "已取消");

    private Integer code;
    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static OrderStatusEnum getByCode(Integer code){
        for (OrderStatusEnum orderStatusEnum : OrderStatusEnum.values()) {
            if (code.equals(orderStatusEnum.code)) {
                return orderStatusEnum;
            }
        }
        return null;
    }
}
