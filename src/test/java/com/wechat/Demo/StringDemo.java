package com.wechat.Demo;

/**
 * Created by lxy on 2019/10/18.
 */
public class StringDemo {


    public static void main(String args[]) {
        //num();
        count();
    }

    //查出小写字母多少个，大写字母多少个，其他多少个
    public static void num() {
        String str = "qwweeeSSSddSddfss*(&ss@^dd";
        int xCount = 0, dCount = 0, qCount = 0;
        //方法一
//        for (int i = 0; i<str.length(); i++) {
//            char ch = str.charAt(i);
//            if (ch >= 'a' && ch <= 'z') {
//                xCount ++;
//            } else if (ch >= 'A' && ch <= 'Z') {
//                dCount ++;
//            } else {
//                qCount ++;
//            }
//        }
        //方法二
        String x = "qwertyuiopasdfghjklzxcvbnm";
        String d = "QWERTYUIOPASDFGHJKLZXCVBNM";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (x.indexOf(ch) != -1) {
                xCount++;
            } else if (d.indexOf(ch) != -1) {
                dCount++;
            } else {
                qCount++;
            }

        }
        System.out.println(xCount + " " + dCount + " " + qCount + " " + str.length());

    }


    //输出在一个字符串中，指定字符串出现的次数
    public static void count() {
        String str = "sunjavassjavasssjavaavajsjs";
        String zd = "java";
        int count = 0;
        int index = -1;

        while ((index = str.indexOf(zd)) != -1) {
            str = str.substring(index + zd.length());
            count++;
        }

        System.out.println(count);
    }

}
