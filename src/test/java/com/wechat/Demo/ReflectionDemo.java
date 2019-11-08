package com.wechat.Demo;


import com.wechat.DTO.CartDTO;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * Created by lxy on 2019/10/8.
 */
public class ReflectionDemo {
    public static void main(String[] args) {

        String name;

        if (args.length > 0) {
            name = args[0];
        } else {
            Scanner in = new Scanner(System.in);
            System.out.print(" 输入java.util.Date");
            name = in.next();
        }

        try {
            Class cl = Class.forName(name);
            Class superClass = cl.getSuperclass();
            String Modifiers = Modifier.toString(cl.getModifiers());
            if (Modifiers.length() > 0) {
                System.out.println("类的名字是" + name);
                System.out.println("类的访问修饰符是" + Modifiers);
                System.out.println("==============类的构造器部分=========");
                printConstructors(cl);
                System.out.println("==============类的方法部分=========");
                getMethod(cl);
                System.out.println("==============类的字段部分=========");
                getFields(cl);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 关于构造器的描述
     */
    public static void printConstructors(Class cl) {

        Constructor[] constructor = cl.getDeclaredConstructors();

        for (Constructor c : constructor) {
            String name = c.getName();
            System.out.println("==============");
            String Modifiers = Modifier.toString(c.getModifiers());
            System.out.println("构造器的访问修饰符" + Modifiers);

            //构造器的参数
            Class[] p = c.getParameterTypes();
            for (int j = 0; j < p.length; j++) {
                System.out.println("构造器参数类型" + p[j].getName());
            }
        }

    }

    /**
     * 关于方法的描述
     */

    public static void getMethod(Class cl) {

        Method[] methods = cl.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println("==============");
            System.out.println("方法名字" + m.getName());
            System.out.println("方法返回类型" + m.getReturnType());
            System.out.println("方法的权限" + Modifier.toString(m.getModifiers()));

            Class[] p = m.getParameterTypes();
            for (int i = 0; i < p.length; i++) {
                System.out.println("方法第" + i + "个参数的类型" + p[i].getName());
            }

        }


    }

    /**
     * 关于字段的描述
     */

    public static void getFields(Class cl) {

        Field[] fields = cl.getDeclaredFields();
        CartDTO cartDTO = new CartDTO("123", 5);
        for (Field f : fields) {
            System.out.println("==============");
            System.out.println("字段名字是" + f.getName());
            System.out.println("字段类型是" + f.getType());
            System.out.println("字段名字修饰符是" + Modifier.toString(f.getModifiers()));

            try {

                f.setAccessible(true);
                System.out.println("==============" + f.get(cartDTO));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }

    }
}
