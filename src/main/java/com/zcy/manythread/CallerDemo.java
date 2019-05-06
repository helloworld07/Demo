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
        String name = Thread.currentThread().getName();
        return name + "running!";
    }

    public static void main(String[] args) {
        FutureTask<String> stringFutureTask = new FutureTask<>(new CallerDemo());
            new Thread(stringFutureTask).start();
        try {
            String s = stringFutureTask.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}