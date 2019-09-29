package com.zcy.redisson;

import org.redisson.Redisson;
import org.redisson.api.RFuture;
import org.redisson.api.RRateLimiter;
import org.redisson.api.RateIntervalUnit;
import org.redisson.api.RateType;

import java.util.concurrent.TimeUnit;

/**
 * @author: George
 * @date: 2019/9/25
 * @description:
 */
public class RedisRateLimiter {
    private static Redisson redisson = RedissonManager.getRedisson();


    public static void main(String[] args) {
        RRateLimiter rateLimiter = redisson.getRateLimiter("myRateLimiter");
        // 初始化
        // 最大流速 = 每1秒钟产生10个令牌
        rateLimiter.trySetRate(RateType.OVERALL, 10, 1, RateIntervalUnit.SECONDS);

        while(true) {
            // 获取4个令牌
            boolean b = rateLimiter.tryAcquire(4, 2, TimeUnit.SECONDS);
            System.out.println(b);
        }

        // 获取4个令牌
        //rateLimiter.tryAcquire(4);

        // 尝试获取4个令牌，尝试等待时间为2秒钟
//        boolean b = rateLimiter.tryAcquire(4, 2, TimeUnit.SECONDS);
//
//        rateLimiter.tryAcquireAsync(2, 2, TimeUnit.SECONDS);
//
//        // 尝试获取1个令牌，等待时间不限
//        rateLimiter.acquire();
//
//        // 尝试获取1个令牌，等待时间不限
//        RFuture<Void> future = rateLimiter.acquireAsync();
    }

}