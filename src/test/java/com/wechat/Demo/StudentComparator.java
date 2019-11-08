package com.wechat.Demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by lxy on 2019/10/14.
 */
public class StudentComparator {

    public static void main(String args[]) {
        compara();
    }


    public static void compara() {
        List<Student> str = new ArrayList<Student>() {
            {
                add(new Student("李1", 18));
                add(new Student("李2", 20));
                add(new Student("李3", 19));
            }
        };
        System.out.println(str);

        Collections.sort(str, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int i = o1.getAge() - o2.getAge();
                System.out.println("==========");
                System.out.println(i);
                System.out.println("==========");
                return i;
            }
        });

        System.out.println("=========");
        System.out.println(str);
    }
}
