package com.wechat.Demo;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

/**
 * Created by lxy on 2019/10/14.
 */
public class lambda {

    public static void main(String args[]) {
        Timer timer = new Timer(5000, e ->
        {
            System.out.print("lambda表达式" + new Date());
            Toolkit.getDefaultToolkit().beep();
        });
        timer.start();
        JOptionPane.showMessageDialog(null, "等5秒");
        System.exit(0);

    }


}
