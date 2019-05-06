package com.zcy.manythread;

/**
 * @author: George
 * @date: 2019/4/19
 * @description:
 */
public class WaitDemo {
    public static void main(String[] args) throws InterruptedException {
        String a = "123";
        synchronized (a){
            while (true){
                a.wait();
            }
        }
    }
}