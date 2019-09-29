package com.example.demeboot.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author: George
 * @date: 2019/9/26
 * @description:
 */
@Service
@Slf4j
public class SyncService {

    @Async("asyncThreadPoolTaskExecutor")
    public void asyncMethod() {
        sleep();
        log.info("异步方法内部线程名称：{}", Thread.currentThread().getName());
    }

    public void syncMethod() {
        sleep();
    }

    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}