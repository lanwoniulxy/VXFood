package com.wechat.Exception;


import com.wechat.Enum.ResultEnum;

/**
 * Created by EDZ on 2019/8/28.
 */
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
