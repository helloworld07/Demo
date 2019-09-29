package com.zcy.forkAndjoin;

import java.util.stream.IntStream;

/**
 * @author: George
 * @date: 2019/9/24
 * @description: 累加计算
 */
public class IntStreamTest {
    public static void main(String[] args) {
        //1~100累加
        int sum = IntStream.rangeClosed(1, 100).sum();
        System.out.println(sum);
    }
}