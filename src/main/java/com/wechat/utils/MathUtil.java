package com.wechat.utils;

/**
 * 金额处理工具类
 * 作用：为了解决微信支付处的数据库金额与微信Api回传的金额校验问题
 * 如果两个金额相减小于0.1,则视为校验通过
 * Created by lxy on 2019/11/10.
 */
public class MathUtil {
    private static final Double MONEY_RANGE= 0.01;

    public static boolean equals (Double d1, Double d2) {
        Double result = Math.abs(d1 - d2);
        if (result < MONEY_RANGE) {
            return true;
        }else {
            return false;
        }
    }
}
