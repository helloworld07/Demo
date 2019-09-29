package com.zcy.Guava;

import com.google.common.collect.LinkedHashMultiset;

/**
 * @author: George
 * @date: 2019/9/4
 * @description: 可以储存多个相同值的set
 */
public class MultiSetTest {
    public static void main(String[] args) {
        LinkedHashMultiset<String> set = LinkedHashMultiset.create();
        set.add("a");
        set.add("a");
        set.add("a");
        set.add("a");
        set.setCount("b", 4);
        System.out.println(set);
        System.out.println(set.size());
        set.clear();
        System.out.println(set);
    }
}