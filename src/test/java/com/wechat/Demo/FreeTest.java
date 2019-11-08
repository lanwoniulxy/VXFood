package com.wechat.Demo;


import com.imooc.DTO.CartDTO;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by EDZ on 2019/9/20.
 */
public class FreeTest {


    public static void main(String args[]) {

        //new FreeTest().num();

        //new FreeTest().random();

        //new FreeTest().hashcodeTest();

        //new FreeTest().fanshe();

//        new FreeTest().chufa();

        //val();
        //new StaticDemo();
        String s = null;
        try {
            if (s.equals(s)) {
            }
        } catch (Exception e) {

        }


    }

    public static void chufa() {
        int i = 128;
        int j = 10;
        int x = i / j;

    }

    public static int val() {
        int num = 5;
        try {
            num = num / 0;
        } catch (Exception e) {
            num = 10;
        } finally {
            num = 15;
        }
        return num;
    }

    //java8测试
    public void num() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
        List<Integer> squaresList = numbers.stream()
                .map(i -> i * i)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(squaresList);
    }

    //随机数测试
    public void random() {
        Random rnd = new Random();
        int code = rnd.nextInt(8999) + 1000;
        System.out.println("code:" + code);
        //毫秒数测试
        Random random = new Random();
        Integer num = random.nextInt(900000) + 100000;

        System.out.println(System.currentTimeMillis() + String.valueOf(num));

    }

    //反射

    //工厂方法
    public void factory() {
        NumberFormat.getCurrencyInstance();
    }

    //散列码测试
    public void hashcodeTest() {
        String a = "OK";
        System.out.println(a.hashCode());
        String b = new String("OK");
        System.out.println(b.hashCode());

    }

    public void fanshe() {
        CartDTO cartDTO = new CartDTO("1", 5);
//        Class c = cartDTO.getClass();
//        System.out.print(c.getName());

        String className = "java.util.Random";

        try {
            Object a = Class.forName(className).newInstance();
            System.out.print(a);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

class StaticDemo {
    static {
        System.out.println("静态代码块");
    }

    {
        System.out.println("代码块");
    }

    private StaticDemo() {
        System.out.println("构造方法");
    }

    public static void demo() {
        System.out.println("静态方法");
    }

    public void demo1() {
        System.out.println("普通方法");
        demo();
    }

}
