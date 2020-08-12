package com.demeboot.async.controller;

import com.demeboot.async.service.SyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: George
 * @date: 2019/9/26
 * @description: 启动类开启@EnableAsync，注释@Async("asyncThreadPoolTaskExecutor")方法开启异步，asyncThreadPoolTaskExecutor为自定义线程池
 */
@RestController
@Slf4j
public class SyncController {


    @Autowired
    private SyncService testService;

    @GetMapping("async")
    public void testAsync() {
        long start = System.currentTimeMillis();
        log.info("异步方法开始");

        testService.asyncMethod();

        log.info("异步方法结束");
        long end = System.currentTimeMillis();
        log.info("总耗时：{} ms", end - start);
    }

    @GetMapping("sync")
    public void testSync() {
        long start = System.currentTimeMillis();
        log.info("同步方法开始");

        testService.syncMethod();

        log.info("同步方法结束");
        long end = System.currentTimeMillis();
        log.info("总耗时：{} ms", end - start);
    }
}