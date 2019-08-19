package com.zcy.manythread;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import static com.zcy.manythread.selfpool.ExecutorPoolTest.THREAD_POOL_EXECUTOR;

/**
 * @author: George
 * @date: 2019/8/16
 * @description:
 */
public class CyclicBarrierTest {
    static CyclicBarrier c = new CyclicBarrier(11);//等待parties个线程执行到await()方法后一起执行。11超出线程个数，卡住
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        c.await();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("执行完毕" + Thread.currentThread().getName());
                }
            };
            THREAD_POOL_EXECUTOR.execute(runnable);
        }
    }
}