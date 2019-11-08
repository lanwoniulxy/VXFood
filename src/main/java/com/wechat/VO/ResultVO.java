package com.wechat.VO;

import lombok.Data;

import java.io.Serializable;


/**
 * Created by lxy on 2019/7/24.
 */
@Data
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = -904180148586534937L;

    /**
     * 错误码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 返回对象
     */
    private T data;
}
