package com.wechat.Demo.DesignDemo;

/**
 * Created by lxy on 2019/10/16.
 */
public class Single {
    public static void main(String args[]) {
        //懒汉
        Lazy l01 = Lazy.getLazy();
        Lazy l02 = Lazy.getLazy();
        System.out.println(l01 == l02);
    }
}

class Lazy {
    private static Lazy lazy = null;

    private Lazy() {
    }

    public static Lazy getLazy() {
        if (lazy == null) {
            lazy = new Lazy();
        }
        return lazy;
    }
}

class Hungry {
    private static Hungry hungry = new Hungry();

    private Hungry() {
    }

    public static Hungry getHungry() {
        return hungry;
    }
}
