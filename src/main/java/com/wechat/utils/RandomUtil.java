package com.wechat.utils;

import java.util.Random;

/**
 * Created by EDZ on 2019/8/26.
 */
public class RandomUtil {

    /**
     * 获取唯一主键
     *
     * @return
     */
    public static synchronized String getUniqueKey() {
        Random random = new Random();
        Integer num = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(num);
    }
}
