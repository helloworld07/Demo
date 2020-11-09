package com.zcy.manythread.futrue;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;


public class CompletableFutureTest {
    @SneakyThrows
    public static void main(String[] args) {
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
//            System.out.println("无返回值！");
        });
        System.out.println(future1.get());
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            return "有返回值";
        });
//        future2.completeExceptionally(new Exception());//有异常则返回异常
//        future2.complete("阻塞中调用即刻返回,get不执行");
        System.out.println(future2.get());
        future2.complete("已阻塞完成调用无效");

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "hello")
                .thenApply(a -> a + " world")
                .thenApply(a -> a + ",")
                .thenApply(a -> a + "I'm coming!");
//                .whenComplete((a,b)-> System.out.println(a+b));
        System.out.println(future3.get());

        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (int i = 0; i < 10000; i++) {
            CompletableFuture<Void> future4 = CompletableFuture.runAsync(() -> {
//                System.out.println(Thread.currentThread() + "Process...");
                atomicInteger.getAndAdd(1);
            });
        }
        System.out.println(atomicInteger.get());

    }
}
