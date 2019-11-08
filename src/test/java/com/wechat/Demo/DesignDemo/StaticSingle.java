package com.wechat.Demo.DesignDemo;

/**
 * Created by lxy on 2019/10/16.
 */
public class StaticSingle {

    private StaticSingle() {

    }

    public static StaticSingle getSingle() {
        return Single.INSTANCE;
    }

    private static class Single {
        private static final StaticSingle INSTANCE = new StaticSingle();
    }
}
