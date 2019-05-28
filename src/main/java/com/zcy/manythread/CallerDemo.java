package com.zcy.manythread;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

/**
 * @author: George
 * @date: 2019/4/19
 * @description:
 */
public class CallerDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        sleep(5000);
        String name = Thread.currentThread().getName();
        return name + "running!";
    }

    public static void main(String[] args) {
        FutureTask<String> stringFutureTask = new FutureTask<>(new CallerDemo());
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.submit(stringFutureTask);
//        new Thread(stringFutureTask).start();
        try {
            System.out.println("before get");//即时执行
            String s = stringFutureTask.get();//等待方法返回，阻塞
            System.out.println(s);
            System.out.println("after get");//待get后才可输出
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}