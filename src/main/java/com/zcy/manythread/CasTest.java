package com.zcy.manythread;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.thread.ThreadUtil;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author: George
 * @date: 2020/8/12
 * @description:
 */
public class CasTest {
    private static int a = 0;
    private static AtomicInteger b = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
//        CountDownLatch countDownLatch = new CountDownLatch(99999);
//        IntStream.range(0, 99999).forEach(i ->
//                ThreadUtil.newThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        a++;
//                        countDownLatch.countDown();
//                    }
//                }, "Thread-1").start());
//        countDownLatch.await();
//        System.out.println(a);


        CountDownLatch countDownLatch = new CountDownLatch(99999);
        IntStream.range(0, 99999).forEach(i ->
                ThreadUtil.newThread(new Runnable() {
                    @Override
                    public void run() {
                        b.incrementAndGet();
                        countDownLatch.countDown();
                    }
                }, "Thread-2").start()
        );
        countDownLatch.await();
        System.out.println(b.get());

    }
}