package com.zcy.manythread;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

import static com.zcy.manythread.selfpool.ExecutorPoolTest.THREAD_POOL_EXECUTOR;

/**
 * @author: George
 * @date: 2019/8/16
 * @description: CyclicBarrier的字面意思是可循环使用（Cyclic）的屏障（Barrier）。它要做的事情是，让一组线程到达一个屏障（也可以叫同步点）时被阻塞，直到最后一个线程到达屏障时，屏障才会开门，所有被屏障拦截的线程才会继续运行
 */
public class CyclicBarrierTest {
    //    static CyclicBarrier c = new CyclicBarrier(11);//等待parties个线程执行到await()方法后一起执行。11超出线程个数，卡住
//    static CyclicBarrier c = new CyclicBarrier(10);
    static CyclicBarrier c = new CyclicBarrier(5, () -> {
        System.out.println("当所有线程到达屏障时，执行该回调");
    });

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