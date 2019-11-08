package com.wechat.Demo;

import lombok.Data;

/**
 * Created by lxy on 2019/10/14.
 */
@Data
public class Student {
    private String name;
    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;

    }
}
