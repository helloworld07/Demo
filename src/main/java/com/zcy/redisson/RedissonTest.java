package com.zcy.redisson;

import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.config.Config;

/**
 * @author: George
 * @date: 2019/8/14
 * @description:
 */
public class RedissonTest {
    public static void main(String[] args) {
        Config config = new Config();
        config.useClusterServers()
                // use "rediss://" for SSL connection
                .addNodeAddress("redis://127.0.0.1:6379");

//        RedissonClient redisson = Redisson.create(config);
//        RMap<Object, Object> myMap = redisson.getMap("myMap");

//        RedissonReactiveClient redissonReactive = Redisson.createReactive(config);
//        RMapReactive<Object, Object> myMap1 = redissonReactive.getMap("myMap");

        RedissonRxClient redissonRx = Redisson.createRx(config);
        RMapRx<Object, Object> myMap2 = redissonRx.getMap("myMap");



    }
}