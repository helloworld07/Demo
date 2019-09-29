package com.zcy.Guava;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author: George
 * @date: 2019/9/24
 * @description: 令牌桶：以恒定速率往桶中放入令牌，请求需要得到令牌后才可执行
 *  aop限制接口流量项目实例参照springboot（demeboot）
 */
public class RateLimiterTest {
    // 1秒钟产生0.5张令牌
    private final static RateLimiter limiter = RateLimiter.create(0.5);

    public static void main(String[] args) {
//        ExecutorService service = Executors.newFixedThreadPool(5);
//        IntStream.range(0, 5).forEach(i -> service.submit(RateLimiterTest::testLimiter));
//        service.shutdown();

        LimiterTest();
    }

    private static void testLimiter() {
        // 当令牌同limiter中有一张（为空时默认为1）令牌时取出令牌，返回等待的时间/秒
        System.out.println(Thread.currentThread() + " waiting " + limiter.acquire());
    }

    public static void LimiterTest(){
        //简单令牌桶
//        RateLimiter limiter = RateLimiter.create(1);
//        System.out.println(limiter.acquire(5));//0.0
//        System.out.println(limiter.acquire(1));//
//        System.out.println(limiter.acquire(1));//

        //冷启动时会以一个比较大的速率慢慢到平均速率
        RateLimiter limiter = RateLimiter.create(5, 1000, TimeUnit.MILLISECONDS);
        for (int i = 0; i < 10;i++) {
            System.out.println(limiter.acquire());
        }
    }
}