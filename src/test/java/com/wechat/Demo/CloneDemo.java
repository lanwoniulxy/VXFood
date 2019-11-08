package com.wechat.Demo;

import lombok.Data;

import java.util.Date;

/**
 * Created by lxy on 2019/10/9.
 */
@Data
public class CloneDemo implements Cloneable {
    private String name;
    private int age;
    private Date date;

    public CloneDemo(String name, int age, Date date) {
        this.name = name;
        this.age = age;
        this.date = date;
    }

}
