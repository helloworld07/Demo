package com.zcy.manythread;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @author: George
 * @date: 2019/5/5
 * @description: ScheduledThreadPoolExecutor抛出异常情况下依然可以继续执行
 */
public class ScheduledThreadPoolExecutorTest {
    static ScheduledThreadPoolExecutor st = new ScheduledThreadPoolExecutor(2);

    public static void main(String[] args) {
        st.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"Task One");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("will throw error");
                throw new RuntimeException("i have a error!!!");
            }
        }, 1000, TimeUnit.MICROSECONDS);

        st.schedule(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                    System.out.println(Thread.currentThread().getName()+"Task Two");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, 2000, TimeUnit.MICROSECONDS);
        st.shutdownNow();
    }

}