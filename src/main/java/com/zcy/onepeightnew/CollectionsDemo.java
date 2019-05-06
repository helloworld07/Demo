package com.zcy.onepeightnew;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: George
 * @date: 2019/4/17
 * @description:
 */
public class CollectionsDemo {
    public static void main(String[] args) {
        List l = new ArrayList<>();
        l.add("aaa");
        l.add("aaa1");
        l.add("aaa2");
        l.add("aba2");
        l.add("aba2");
        l.add("bbb");
        l.add("bbb1");
        l.add("bbb2");
        l.add("aaa3");
        l.add("aba");
        l.add("aba1");

        l.stream()
                .filter((s)->s.equals("aaa3"))
                .forEach(System.out::println);

        l.stream()
                .sorted()
                .distinct()
                .forEach(System.out::println);
    }
}