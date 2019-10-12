package com.wechat.Exception;

/**
 * Created by EDZ on 2019/8/28.
 */
public class SellException extends RuntimeException {
    private Integer code;

    public SellException() {
    }

    public SellException(String message) {
        super(message);
    }

    public SellException (Integer code, String message) {
        super(message);
        this.code = code;
    }
}
