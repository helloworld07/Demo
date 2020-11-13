package com.zcy.manythread.futrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class CompletableDeadLock {
    public static final ExecutorService POOL = Executors.newFixedThreadPool(3, new ThreadFactory() {

        final AtomicInteger count = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("pool-thread[" + count.getAndIncrement() + "]");
            return thread;
        }
    });

    public static void main(String[] args) {

        List<CompletableFuture<Void>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            CompletableFuture<Void> fu = CompletableFuture.runAsync(() -> {
                try {
                    Thread.sleep(1000); // 注释掉这个sleep，有可能正常运行
                    System.out.println("父任务执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //父任务获取线程池内线程后到此还未放回去，下面子任务就取不到线程了，导致死锁
                CompletableFuture<Void> childF = CompletableFuture.runAsync(() -> {
                    System.out.println("子任务执行了");
                }, POOL);
                childF.join();
            }, POOL);

            System.out.println(String.format("第 %s 个父任务等待完成", i));
            list.add(fu);

        }
        CompletableFuture.allOf(list.toArray(new CompletableFuture[0])).join();
        POOL.shutdown();
        System.out.println("exit");
    }
}
