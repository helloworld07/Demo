package com.zcy.manythread;

/**
 * @author: George
 * @date: 2019/4/19
 * @description:
 */
public class RunnableDemo implements Runnable{

    @Override
    public void run() {
        System.out.println("123");
    }

    public static void main(String[] args) {
        RunnableDemo runnableDemo = new RunnableDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(runnableDemo).start();
        }
    }
}
