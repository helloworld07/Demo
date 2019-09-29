package com.zcy.Guava;

import com.google.common.base.Joiner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: George
 * @date: 2019/9/3
 * @description: Joiner的实例不可变的，因此是线程安全的。字符串拼接，list,map拼接
 */
public class JoinerTest {
    public static void main(String[] args) {
        /*Joiner joiner = Joiner.on(',');
        joiner.skipNulls(); // does nothing!分开写跳过null就不起作用了，因为实例不可改变
        String join = joiner.join("123", null, "456");
        System.out.println(join);*/

        String join1 = Joiner.on(',').skipNulls().join("123", null, "456");
        System.out.println(join1);

        StringBuilder sb = new StringBuilder();
        Joiner.on(",").skipNulls().appendTo(sb, "Hello", "guava");
        System.out.println(sb);
        System.out.println(Joiner.on(",").useForNull("none").join(1, null, 3));
        System.out.println(Joiner.on(",").skipNulls().join(Arrays.asList(1, 2, 3, 4, null, 6)));
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        System.out.println(Joiner.on(",").withKeyValueSeparator("=").join(map));
    }
}