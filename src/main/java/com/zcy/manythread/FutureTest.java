package com.zcy.manythread;

import java.util.concurrent.*;

/**
 * @author: George
 * @date: 2019/5/6
 * @description:
 */
public class FutureTest {
    private final static ThreadPoolExecutor tpe = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(1), new ThreadPoolExecutor.DiscardPolicy());

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future taskOne = tpe.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("start taskOne");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Future taskTwo = tpe.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("start taskTwo");
            }
        });

        Future taskThree = null;
        try {
            taskThree = tpe.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("start taskThree");
                }
            });
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        System.out.println("taskOne: "+taskOne.get());
        System.out.println("taskTwo: "+taskTwo.get());
        try {
            System.out.println("taskThree:"+(taskThree==null?null:taskThree.get(1,TimeUnit.SECONDS)));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}