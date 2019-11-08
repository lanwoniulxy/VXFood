package com.wechat.Demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * 匿名类
 * Created by lxy on 2019/10/14.
 */
public class AnonymousInnerDemo {
    public static void main(String args[]) {
        TalkingClock talkingClock = new TalkingClock();
        talkingClock.start(5000, true);
        JOptionPane.showMessageDialog(null, "等5秒");
        System.exit(0);

    }
}

class TalkingClock {

    public void start(int interval, boolean beep) {
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("匿名测试类 时钟" + new Date());
                if (beep == true) {
                    Toolkit.getDefaultToolkit().beep();
                }
            }

        };
        Timer timer = new Timer(interval, actionListener);
        timer.start();

    }

}