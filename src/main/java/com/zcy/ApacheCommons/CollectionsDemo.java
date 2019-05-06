package com.zcy.ApacheCommons;

import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.bidimap.TreeBidiMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author: George
 * @date: 2019/4/18
 * @description:
 */
public class CollectionsDemo {
    public static void main(String[] args) {
        TreeBidiMap treeBidiMap = new TreeBidiMap();
        treeBidiMap.put("1","a");
        treeBidiMap.put("22","bb");
        treeBidiMap.put("333","ccc");

        BidiMap bidiMap = treeBidiMap.inverseBidiMap();
        String a = (String) bidiMap.getKey("1");
        System.out.println(a);

        List l = new ArrayList<>();
        List l2 = new ArrayList<>();
        l.add("1");
        l.add("12");
        l.add("56");
        l.add("3");
        l.add("39");
        l2.add("1");
        l2.add("13");
        l2.add("55");
        l2.add("31");
        l2.add("39");

        Collection collection = CollectionUtils.retainAll(l, l2);
        collection.parallelStream().forEach((s)-> System.out.println(s));

    }
}