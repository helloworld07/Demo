package com.zcy.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author: George
 * @date: 2019/6/12
 * @description:
 */
public class iteratorMapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        //1.8遍历map
        map.forEach((key, value) -> {
            System.out.println("key=" + key + " value=" + value);
        });
        //通用遍历map方式
        Iterator<Map.Entry<String,String>> entryIterator = map.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, String> next = entryIterator.next();
            System.out.println("key=" + next.getKey() + " value=" + next.getValue());
        }
    }
}