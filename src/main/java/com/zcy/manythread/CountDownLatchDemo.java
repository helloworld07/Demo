package com.zcy.manythread;

import cn.hutool.core.util.RandomUtil;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: George
 * @date: 2019/4/30
 * @description:
 */
public class CountDownLatchDemo {
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);
    private static ExecutorService executorServiceShop = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 80; i++) {
            executorServiceShop.submit(new Runnable() {
                @Override
                public void run() {
                    CountDownLatch countDownLatch = new CountDownLatch(2);
                    //线程A
                    executorService.submit(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } finally {
                                countDownLatch.countDown();
                            }
                            System.out.println(Thread.currentThread().getName()+":thread a is over");
                        }
                    });
                    //线程B
                    executorService.submit(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(RandomUtil.randomInt(1,9)*1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } finally {
                                countDownLatch.countDown();
                            }
                            System.out.println(Thread.currentThread().getName()+":thread b is over");
                        }
                    });
                    System.out.println(Thread.currentThread().getName()+":wait all children thread over");
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("#####"+Thread.currentThread().getName()+":all children thread is over");
//                    executorService.shutdown();
                }
            });
        }


    }

}