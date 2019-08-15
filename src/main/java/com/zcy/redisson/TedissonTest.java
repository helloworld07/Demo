package com.zcy.redisson;

import com.zcy.manythread.selfpool.ExecutorPoolTest;

/**
 * @author: George
 * @date: 2019/8/15
 * @description:
 */
public class TedissonTest {
    public static void main(String[] args) throws InterruptedException {
        String key = "testRedisLock001";
        for (int i = 0; i < 20; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        //多线程场景，线程处理需等待锁的释放，未测试效率如何？
                        //redisson应该应用于分布式场景中，多个系统可同时通过redis来获取同一个锁
                        //加锁
                        RedisLockUtil.acquire(key);//woc?如果上次异常退出，key就一直锁住了？
                        //执行具体业务逻辑(暂时未想到合适的例子)
                        Thread.sleep(3000);
                        //释放锁
                        RedisLockUtil.release(key);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("执行完毕" + Thread.currentThread().getName());
                }
            };
            //丢给线程池去执行
            ExecutorPoolTest.THREAD_POOL_EXECUTOR.execute(runnable);
        }
    }
}