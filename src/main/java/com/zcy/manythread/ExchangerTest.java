package com.zcy.manythread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * @author: George
 * @date: 2019/9/24
 * @description: 两个线程通过Exchanger交换数据的简单示例
 * 当成对的线程都到达同步点的时候，才会执行数据交换操作
 * 线程匹配是随机的，可能出现3个线程中thread1和thread2匹配，thread3进入无休止的等待
 * Exchanger交换的是同一个对象，而不是对象的拷贝
 */
public class ExchangerTest {
    public static void main(String[] args) {
        final Exchanger<String> exchanger = new Exchanger<>();

        new Thread(() -> {
            System.out.println("thread1开始");
            try {
                String exchange = exchanger.exchange("来自thread1的数据");
                System.out.println("接收thread2发送的数据：" + exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread1结束");
        }, "thread1").start();

        new Thread(() -> {
            System.out.println("thread2开始");
            try {
                TimeUnit.SECONDS.sleep(3); // thread1也会进入等待，直到双方都准备好交换数据。
                String exchange = exchanger.exchange("来自thread2的数据");
                System.out.println("接收thread1发送的数据：" + exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread2结束");
        }, "thread2").start();
    }
}