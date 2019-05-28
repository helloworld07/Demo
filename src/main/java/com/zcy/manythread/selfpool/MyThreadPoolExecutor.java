package com.zcy.manythread.selfpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: George
 * @date: 2019/5/22
 * @description:
 */
public class MyThreadPoolExecutor extends ThreadPoolExecutor {
    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        System.out.println(t.getName() + "is running,TID:" + t.getId());
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        System.out.println("after Executor!");
    }
}