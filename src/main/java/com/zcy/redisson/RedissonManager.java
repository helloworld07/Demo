package com.zcy.redisson;

import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.config.Config;

/**
 * @author: George
 * @date: 2019/8/14
 * @description:
 */
public class RedissonManager {
        private static Config config = new Config();
        //声明redisso对象
        private static Redisson redisson = null;
        //实例化redisson
        static{
            config.useSingleServer().setAddress("redis://127.0.0.1:6379");
            //得到redisson对象
            redisson = (Redisson) Redisson.create(config);

        }

        //获取redisson对象的方法
        public static Redisson getRedisson(){
            return redisson;
        }

}