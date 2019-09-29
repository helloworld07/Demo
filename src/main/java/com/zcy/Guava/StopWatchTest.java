package com.zcy.Guava;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

/**
 * @author: George
 * @date: 2019/9/24
 * @description:
 */
public class StopWatchTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("程序开始处理");
        Stopwatch stopwatch = Stopwatch.createStarted();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("程序处理结束，耗时" + stopwatch.stop());
    }
}