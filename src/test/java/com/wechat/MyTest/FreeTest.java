package com.wechat.MyTest;

import com.wechat.DTO.CartDTO;

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

        new FreeTest().chufa();
    }

    //java8测试
    public void num() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
        List<Integer> squaresList = numbers.stream()
                .map( i -> i*i)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(squaresList);
    }

    //随机数测试
    public void random() {
        Random rnd = new Random();
        int code = rnd.nextInt(8999) + 1000;
        System.out.println("code:"+code);
        //毫秒数测试
        Random random = new Random();
        Integer num = random.nextInt(900000) + 100000;

        System.out.println(System.currentTimeMillis() + String.valueOf(num));

    }

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

    //反射

    public void fanshe(){
       CartDTO cartDTO = new CartDTO("1",5);
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

    public static void chufa() {
        int i =128;
        int j = 10;
        int x = i / j ;



    }

}
