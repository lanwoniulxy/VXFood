package com.wechat.Demo;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


/**
 * Created by lxy on 2019/10/14.
 */
public class TimerDemo {

    public static void main(String args[]) {
        ActionListener actionListener = new TimerPrint();
        Timer timer = new Timer(5000, actionListener);
        timer.start();
        //对话框
        JOptionPane.showMessageDialog(null, "quit");
        //终止程序
        System.exit(0);
    }
}

//一个java文件中只能有一个Public的类
class TimerPrint implements ActionListener {
    //ActionListener可以理解成一个监听器，让定时器知道需要调用哪个方法
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("我在写一个定时器demo" + new Date());
        //叮的一声
        Toolkit.getDefaultToolkit().beep();
    }
}

