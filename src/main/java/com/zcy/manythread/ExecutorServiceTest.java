package com.zcy.manythread;

import cn.hutool.core.thread.ThreadUtil;

import java.util.concurrent.*;

/**
 * @author: George
 * @date: 2020/7/15
 * @description:
 */
public class ExecutorServiceTest {
    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        for (int i = 0; i < 10; i++) {
            forkJoinPool.submit(new Runnable() {
                @Override
                public void run() {
                    ExecutorService executorService = Executors.newFixedThreadPool(5);
                    CountDownLatch latch = new CountDownLatch(2);
                    executorService.execute(new Runnable() {
                        @Override
                        public void run() {
                            ThreadUtil.sleep(2000);
                            System.out.println("a is over");
                            latch.countDown();
                        }
                    });
                    executorService.execute(new Runnable() {
                        @Override
                        public void run() {
                            ThreadUtil.sleep(3000);
                            System.out.println("b is over");
                            latch.countDown();
                        }
                    });
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    executorService.shutdown();
                    System.out.println("finished!");
                }
            });
        }
        forkJoinPool.awaitTermination(1, TimeUnit.SECONDS);
    }
}