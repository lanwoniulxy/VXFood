package com.wechat.Demo;

/**
 * Created by lxy on 2019/10/15.
 */

public class RAMDemo {


    public static void main(String args[]) {
        RAMDemo ramDemo = new RAMDemo();
        int date = 9;
        BirthDay b01 = new BirthDay(2019, 10, 15);
        BirthDay b02 = new BirthDay(1997, 07, 30);

        ramDemo.change01(date);
        ramDemo.change02(b01);
        ramDemo.change03(b02);
    }

    public void change01(int i) {
        i = 1234;
    }

    public void change02(BirthDay b) {
        b = new BirthDay(2000, 10, 16);
    }

    public void change03(BirthDay b) {
        b.setDay(22);
    }

}


class BirthDay {

    private int year;
    private int month;
    private int day;
    public BirthDay() {
    }
    public BirthDay(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}