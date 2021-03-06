package com.zcy.manythread;

import cn.hutool.core.thread.ThreadUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author: George
 * @date: 2019/9/24
 * @description: StampedLock解决了在没有新数据写入时，由于过多读操作抢夺锁而使得写操作一直获取不到锁无法写入新数据的问题。
 * 乐观读，悲观写。当有写入锁时，与ReentrantReadWriteLock读写锁一样，但是当没有写锁时，可少获取一次读锁，进而提高效率。
 */
public class StampedLockTest {
    private static StampedLock lock = new StampedLock();
    private static List<Long> data = new ArrayList<>();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);

        Runnable read = StampedLockTest::read;
        Runnable write = StampedLockTest::write;

        IntStream.range(0, 19).forEach(i -> executorService.submit(read));
        ThreadUtil.sleep(1000);
        executorService.submit(write);

        executorService.shutdown();
    }

    private static void read() {
        long stamped = lock.tryOptimisticRead(); // 获取乐观锁
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 直接读取值
        String collect = data.stream().map(String::valueOf).collect(Collectors.joining(","));

        // 如果戳被改变，方法返回false，说明stamped被修改过了（被write方法修改过了，有新的数据写入），
        // 那么重新获取锁并去读取值，否则直接使用上面读取的值。
        if (!lock.validate(stamped)) {
            try {
                stamped = lock.readLock();
                TimeUnit.SECONDS.sleep(1);
                collect = data.stream().map(String::valueOf).collect(Collectors.joining(","));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlockRead(stamped);
            }
        }
        System.out.println(Thread.currentThread().getName() + " read value: " + collect);
    }

    private static void write() {
        long stamped = -1;
        try {
            stamped = lock.writeLock();
            TimeUnit.SECONDS.sleep(1);
            long value = System.currentTimeMillis();
            data.add(value);
            System.out.println(Thread.currentThread().getName() + " write value: " + value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlockWrite(stamped);
        }
    }
}