package com.zcy.manythread;

import cn.hutool.core.thread.ThreadUtil;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: George
 * @date: 2020/7/17
 * @description:
 */
public class CountDownAwait {
    private static ExecutorService shopExecutorService = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            shopExecutorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        ThreadUtil.sleep(1000);
                        System.out.println("hehe");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            });
        }
        countDownLatch.await();
    }
}