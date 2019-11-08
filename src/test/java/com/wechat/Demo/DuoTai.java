package com.wechat.Demo;

/**
 * Created by lxy on 2019/10/17.
 */
public class DuoTai {
    public static void main(String args[]) {
        Cat cat = new Cat("猫1");
        Dog dog = new Dog("狗1");
        Boy xiaowang = new Boy("小王", cat);
        Boy xiaoli = new Boy("小李", dog);
        xiaowang.getEnjoy();
        xiaoli.getEnjoy();

    }
}

class Animals {
    private String name;

    public void enjoy() {
        System.out.println("动物叫声");
    }
}

class Cat extends Animals {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public void enjoy() {
        System.out.println("猫叫声");
    }

}

class Dog extends Animals {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public void enjoy() {
        System.out.println("狗叫声");
    }
}

class Boy {

    private String name;
    private Animals animals;
    public Boy(String name, Animals animals) {
        this.animals = animals;
        this.name = name;
    }

    public void getEnjoy() {
        animals.enjoy();
    }
}