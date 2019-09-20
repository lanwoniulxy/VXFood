package com.imooc;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by EDZ on 2019/9/20.
 */

public class FreeTest {

    public static void main(String args[]) {
        //java8 测试
//        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
//        // 获取对应的平方数
//        List<Integer> squaresList = numbers.stream()
//                .map( i -> i*i)
//                .distinct()
//                .collect(Collectors.toList());
//        System.out.println(squaresList);

        // 随机数测试
//        Random rnd = new Random();
//        int code = rnd.nextInt(8999) + 1000;
//        System.out.println("code:"+code);
        // 毫秒数测试
        Random random = new Random();
        Integer num = random.nextInt(900000) + 100000;

        System.out.println(System.currentTimeMillis() + String.valueOf(num));

    }


}
