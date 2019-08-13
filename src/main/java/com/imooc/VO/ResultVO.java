package com.imooc.VO;

import lombok.Data;

/**
 * Created by lxy on 2019/7/24.
 */
@Data
public class ResultVO<T> {
    /**
     *错误码
     */
    private Integer code;
    /**
     *提示信息
     */
    private String msg;
    /**
     *返回对象
     */
    private T data;
}
