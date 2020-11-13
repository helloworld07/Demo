package com.zcy.manythread.futrue;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CompletableFuture<AtomicInteger> future4 = CompletableFuture.supplyAsync(() -> {
            for (int i = 0; i < 1000000; i++) {
                atomicInteger.addAndGet(1);
            }
            return atomicInteger;
        },executorService)
                .thenApply(a -> {
                    a.set(a.get() / 5000);
                    return a;
                });//supplyAsync计算完成后thenApply再开始计算
        System.out.println(future4.get());
        executorService.shutdown();

    }
}
