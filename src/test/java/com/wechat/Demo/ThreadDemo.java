package com.wechat.Demo;

/**
 * Created by lxy on 2019/10/25.
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Runner runner = new Runner();
        Thread thread = new Thread(runner);
        thread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("main方法" + i);
        }
    }
}

class Runner implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("分支方法" + i);
        }
    }
}