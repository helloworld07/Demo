package com.zcy.onepeightnew;

import java.util.stream.IntStream;

/**
 * @author: George
 * @date: 2019/8/19
 * @description:
 */
public class IntStreamDemo {
    public static void main(String[] args) {
        IntStream.range(0, 5).forEach(i -> System.out.println(i));
    }
}