package com.zcy.Guava;

import com.google.common.collect.HashBiMap;

/**
 * @author: George
 * @date: 2019/9/4
 * @description:
 */
public class BiMapTest {
    public static void main(String[] args) {
        HashBiMap<String, String> biMap = HashBiMap.create();
        biMap.put("a", "111");
        biMap.put("b", "222");
//        biMap.put("c", "111");//报错
        System.out.println(biMap);
        biMap.forcePut("d","111");
        System.out.println(biMap);
        System.out.println(biMap.inverse().get("222"));//通过值找键
    }
}