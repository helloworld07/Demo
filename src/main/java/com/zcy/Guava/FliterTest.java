package com.zcy.Guava;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author: George
 * @date: 2019/9/4
 * @description: 集合过滤器
 */
public class FliterTest {
    public static void main(String[] args) {
        ArrayList<String> list = Lists.newArrayList("moon", "dad", "refer","sdsdsa");
        Collection<String> filter = Collections2.filter(list, l -> {
            return new StringBuilder(l).reverse().toString().equals(l);
        });
        System.out.println(filter);
    }
}