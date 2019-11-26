package com.wechat.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by lxy on 2019/11/9.
 */
public class JsonUtil {
    public static String toJson (Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
