package com.zcy.Guava;

import com.google.common.collect.HashMultimap;

/**
 * @author: George
 * @date: 2019/9/4
 * @description: Multimap是把键映射到任意多个值的一般方式。
 */
public class MultiMapTest {
    public static void main(String[] args) {
        HashMultimap<String, Integer> map = HashMultimap.create();
        map.put("a", 1);
        map.put("a", 2);
        map.put("a", 3);
        map.put("a", 4);
        map.put("b", 5);
        System.out.println(map);
        System.out.println(map.get("a"));
        System.out.println(map.keySet().size());
    }
}