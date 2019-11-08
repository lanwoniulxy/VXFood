package com.wechat.Demo;

import java.util.Comparator;

/**
 * 比较器
 * <p>
 * Created by lxy on 2019/10/14.
 */

public class LengthComparatorDemo implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
//        Arrays.sort();
    }
}
