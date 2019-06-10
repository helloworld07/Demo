package com.zcy.onepeightnew;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: George
 * @date: 2019/5/31
 * @description:
 */
public class StreamAndForTest {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<Integer>();

        for (int i = 0; i < 1000000; i++) {
            if (i == 996 || i == 123 || i == 888 || i == 666) {
                l.add(4);
            } else {
                l.add(1);
            }
        }

        List<Integer> ll = new ArrayList<Integer>();
        List<Integer> lll = new ArrayList<Integer>();

        long s1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            if (l.get(i)==1){
                ll.add(l.get(i));
            }
        }
        long e1 = System.currentTimeMillis();
        System.out.println(e1 - s1);


        long s2 = System.currentTimeMillis();
        l.stream().filter(a->a==1).forEach(lll::add);
        long e2 = System.currentTimeMillis();
        System.out.println(e2 - s2);
        System.out.println("=======================");

    }
}