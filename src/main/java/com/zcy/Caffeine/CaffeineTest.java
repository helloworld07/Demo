package com.zcy.Caffeine;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.map.MapUtil;
import com.github.benmanes.caffeine.cache.*;
import org.apache.commons.collections.ListUtils;

import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

/**
 * @author: George
 * @date: 2019/9/2
 * @description: Caffeine缓存
 */
public class CaffeineTest {
    public static void main(String[] args) throws InterruptedException {
        //一般构造
        Cache<String, String> cache = Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.SECONDS)
                .expireAfterAccess(1, TimeUnit.SECONDS)
                .maximumSize(10)
                .build();
        cache.put("hello1", "hello123");//写入值
        cache.put("hello2", "hello123");//写入值
        cache.put("hello3", "hello123");//写入值
        cache.put("hello4", "hello123");//写入值
        cache.put("hello5", "hello123");//写入值
        List<String> l = CollectionUtil.newArrayList("hello1", "hello2", "qqq");
        Map<String, String> allPresent = cache.getAllPresent(l);
        allPresent.forEach((k,v)->{

        });
        sleep(500);
        String hello = cache.getIfPresent("hello");//获取值，若没有则为null
        System.out.println(hello);
        String haha = cache.get("hahaha", k -> keyToValue(k));//获取值，若没有则按keyToValue()方法写入并返回此写入值
        System.out.println(haha);
        cache.invalidate("hahahaqqq");

        //同步构造
        LoadingCache<String, Object> loadingCache = Caffeine.newBuilder()
                .maximumSize(10_000)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .build(key -> keyToValue(key));
        String hehe = (String) loadingCache.get("hehe");
        System.out.println(hehe);
        List<String> keys = new ArrayList<>();
        keys.add("sf");
        keys.add("sf1");
        keys.add("sf2");
        keys.add("sf3");
        keys.add("sf4");
        Map<String, Object> all = loadingCache.getAll(keys);

        //异步构造
        AsyncLoadingCache<String, Object> asyncLoadingCache = Caffeine.newBuilder()
                .maximumSize(10_000)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                // Either: Build with a synchronous computation that is wrapped as asynchronous
                .buildAsync(CaffeineTest::ketToValue2);
        List<String> lists = new ArrayList<>();
        lists.add("yyy1");
        lists.add("yyy2");
        lists.add("yyy3");
        lists.add("yyy4");
        lists.add("yyy5");
        CompletableFuture<Map<String, Object>> graphs = asyncLoadingCache.getAll(lists);


        //驱逐策略
        /*基于大小：
            缓存大小：
                    Caffeine.maximumSize(long)方法来指定缓存的最大容量
            权重：
                    Caffeine.weigher(Weigher) 函数来指定权重，使用Caffeine.maximumWeight(long) 函数来指定缓存最大权重值
        * 基于时间：
        *            Caffeine.expireAfterAccess(5, TimeUnit.MINUTES) 相当于过期时间
        * 基于引用：
        *            Caffeine.weakKeys().weakValues()当key和value都没有引用时驱逐缓存
        *            Caffeine.softValues()当垃圾收集器需要释放内存时驱逐*/

        //监听Removal ：监听删除的key
        /*个人使用：监听器有延时，删除时并不一定会实时有返回*/
        Cache<String, String> cacheRemoval = Caffeine.newBuilder()
                .removalListener((String key, String value, RemovalCause cause) ->
                        System.out.println("delete,key:" + key + ",value:" + value + ",cause:" + cause))
                .expireAfterAccess(1, TimeUnit.SECONDS)
                .build();
        cacheRemoval.put("hero jugg", "good");
        cacheRemoval.put("hero sf", "bad");
        cacheRemoval.put("hero tf", "old");
        cacheRemoval.put("hero aa", "old");
        cacheRemoval.put("hero sb", "old");
        cacheRemoval.put("hero ck", "old");
        sleep(5000);
        cacheRemoval.invalidate("hero jugg");
        cacheRemoval.invalidate("hero sf");
        System.out.println(cacheRemoval.stats());
    }

    public static String keyToValue(String key) {
        return key + "qqq";
    }

    public static String ketToValue2(String key) {
        return key + "sync";
    }
}