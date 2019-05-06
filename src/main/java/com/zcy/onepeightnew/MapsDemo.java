package com.zcy.onepeightnew;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: George
 * @date: 2019/4/17
 * @description:
 */
public class MapsDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }
//        map.forEach((id, val) -> System.out.println(val));
        map.computeIfPresent(3, (key, val) -> val + key);
        System.out.println(map.get(3));

        map.computeIfPresent(9, (num, val) -> null);
        map.containsKey(9);     // false

        map.computeIfAbsent(23, num -> "val" + num);
        map.containsKey(23);    // true

        map.computeIfAbsent(3, num -> "bam");
        map.get(3);             // val33
    }
}