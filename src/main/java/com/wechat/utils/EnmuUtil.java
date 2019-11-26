package com.wechat.utils;

import com.wechat.Enum.CodeEnum;

/**
 * 枚举工具类
 * 作用：为了解决字段（数字）在页面显示的问题
 * Created by lxy on 2019/11/11.
 */
public class EnmuUtil {

    //通过一个code获取一个枚举
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enmuClass) {
        for (T each: enmuClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
