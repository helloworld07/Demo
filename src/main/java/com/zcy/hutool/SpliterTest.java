package com.zcy.hutool;

import cn.hutool.core.text.StrSpliter;

import java.util.List;

/**
 * @author: George
 * @date: 2019/9/9
 * @description:
 */
public class SpliterTest {
    public static void main(String[] args) {
        String s = "1,2,3,a,b,,  c,   ";
        List<String> split = StrSpliter.split(s, ',', 0, true, true);
        System.out.println(split);
    }
}