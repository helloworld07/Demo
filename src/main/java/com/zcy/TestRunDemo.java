package com.zcy;

import com.zcy.itf.testInterface;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Predicate;

/**
 * @author: George
 * @date: 2019/4/16
 * @description:
 */
public class TestRunDemo {
    public static void main(String[] args) {
        testInterface testInterface = new testInterface() {
            @Override
            public double caculate(int a) {
                return sqrt(a * 100);
            }
        };
        System.out.println(testInterface.caculate(100));
        System.out.println(testInterface.sqrt(16));

        List<String> names = Arrays.asList("4", "3", "5", "1");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        System.out.println(names);

        Collections.sort(names, (String a, String b) ->
                b.compareTo(a)
        );
        System.out.println(names);

        names.sort((a,b)->b.compareTo(a));
        System.out.println(names);
    }
}