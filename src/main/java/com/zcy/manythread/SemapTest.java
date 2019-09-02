package com.zcy.manythread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author: George
 * @date: 2019/8/29
 * @description: 锁的容量为5，所以每次处理5个线程
 */
public class SemapTest implements Runnable {

    final Semaphore semp = new Semaphore(5);

    @Override
    public void run() {
        try {
            //获取一个permit
            semp.acquire();
            // 模拟耗时操作
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId() + ": done!");
            //释放一个permit
            semp.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(20);
        final SemapTest demo = new SemapTest();
        for (int i = 0; i < 20; i++) {
            exec.submit(demo);
        }
    }

}