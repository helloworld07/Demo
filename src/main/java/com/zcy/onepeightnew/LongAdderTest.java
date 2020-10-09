package com.zcy.onepeightnew;

import cn.hutool.core.thread.ThreadUtil;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

/**
 * @author: George
 * @date: 2020/8/14
 * @description:
 */
public class LongAdderTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(9999);
        LongAdder longAdder = new LongAdder();
        IntStream.range(0, 9999).forEach(i ->
                ThreadUtil.newThread(new Runnable() {
                    @Override
                    public void run() {
                        longAdder.increment();
                        countDownLatch.countDown();
                    }
                }, "Thread-1").start()
        );
        countDownLatch.await();
        System.out.println(longAdder.sum());
    }
}