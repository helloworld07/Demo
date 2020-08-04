package com.zcy.forkAndjoin;

import cn.hutool.core.thread.ThreadUtil;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * @author: George
 * @date: 2020/7/15
 * @description:
 */
public class forkJoinTest {
    public static void main(String[] args) throws InterruptedException {
//        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "4");
//        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        ForkJoinPool forkJoinPool = new ForkJoinPool(5);
        for (int i = 0; i < 10; i++) {
            forkJoinPool.submit(new Runnable() {
                @Override
                public void run() {
                    ThreadUtil.sleep(5000);
                    System.out.println("线程执行完成");
                }
            });
        }
        forkJoinPool.awaitQuiescence(2,TimeUnit.HOURS);
//        forkJoinPool.awaitTermination(2, TimeUnit.HOURS);
        System.out.println("finished!");
    }
}