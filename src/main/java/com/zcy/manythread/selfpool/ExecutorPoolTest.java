package com.zcy.manythread.selfpool;

import com.zcy.manythread.selfpool.MyThreadPoolExecutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: George
 * @date: 2019/5/21
 * @description:
 */
public class ExecutorPoolTest {

    //ExecutorService executorService = Executors.newFixedThreadPool();//不建议使用Executors直接调用线程池

    //线程池参数
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = Math.max(4, Math.min(CPU_COUNT - 1, 5)); //一共执行20个任务 ,核心线程数是4，最大核心线程数是10，目前加入的runnable20个(相当于20个任务），
    private static final int MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 2;
    private static final BlockingQueue sPoolWorkQueue = new LinkedBlockingQueue<>(10); //20个任务需要执行，但是核心线程数只有4个，还有16个任务，由于LinkedBlockingQueue队列是最大存放的任务为10 个，队列满了，则会创建新的线程去执行任务，这个时候最大线程是10， 非核心线LinkedBlockingQueue数还有6个，这时候会开6个线程去执行， 目前达到10个最大线程数，此时队列里面还有10个。正好满足队列的大小
    private static ThreadPoolExecutor THREAD_POOL_EXECUTOR = null;
    private static ThreadPoolExecutor SELF_THREAD_POOL = null;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    //规则：线程最大线程数+队列数>=任务数

    //直接定义线程池（常用）
    static {
        System.out.println("核心线程数=" + CORE_POOL_SIZE);
        System.out.println("最大线程数=" + MAXIMUM_POOL_SIZE);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, //核心线程数
                MAXIMUM_POOL_SIZE, //线程池中最大的线程数
                60, //线程的存活时间，没事干的时候，空闲的时间
                TimeUnit.SECONDS, //线程存活时间的单位
                sPoolWorkQueue, //线程缓存队列
                new ThreadFactory() { //线程创建工厂，如果线程池需要创建线程会调用newThread来创建
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r,"George's thread-"+atomicInteger.getAndIncrement());
                        thread.setDaemon(false);
                        return thread;
                    }
                });
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        THREAD_POOL_EXECUTOR = threadPoolExecutor;

        //自定义线程池,定义线程执行前后的任务，便于日志输出
//        MyThreadPoolExecutor myThreadPoolExecutor = new MyThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 60, TimeUnit.SECONDS, sPoolWorkQueue);
//        SELF_THREAD_POOL = myThreadPoolExecutor;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("执行完毕" + Thread.currentThread().getName());
                }
            };
            //丢给线程池去执行
            THREAD_POOL_EXECUTOR.execute(runnable);
//            SELF_THREAD_POOL.execute(runnable);
        }
    }
}