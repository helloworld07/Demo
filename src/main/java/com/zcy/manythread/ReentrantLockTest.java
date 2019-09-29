package com.zcy.manythread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * @author: George
 * @date: 2019/9/24
 * @description:
 */
public class ReentrantLockTest {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        IntStream.range(0, 10).forEach(i -> new Thread(ReentrantLockTest::needLock).start());
    }
    public static void needLock() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "开始工作");
            Thread.currentThread().getId();
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}