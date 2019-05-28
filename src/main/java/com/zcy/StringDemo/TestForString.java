package com.zcy.StringDemo;

import java.nio.IntBuffer;
import java.util.Arrays;

/**
 * @author: George
 * @date: 2019/5/9
 * @description:
 */
public class TestForString {
    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";
        System.out.println(a==b);//true
        String c = new String("abc");
        System.out.println(a==c);//false
        System.out.println(a==c.intern());//true

        String d = "a;b:c'd";
        String[] split = d.split("[;|:|']");//split支持正则表达式
        Arrays.stream(split).forEach(s -> System.out.println(s));

    }

}