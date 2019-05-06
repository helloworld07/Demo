package com.zcy.manythread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: George
 * @date: 2019/4/30
 * @description:
 */
public class CountDownLatchDemo {
    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        //线程A
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
                System.out.println("thread a is over");
            }
        });
        //线程B
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
                System.out.println("thread b is over");
            }
        });
        System.out.println("wait all children thread over");
        countDownLatch.await();
        System.out.println("all children thread is over");
        executorService.shutdown();
    }
}