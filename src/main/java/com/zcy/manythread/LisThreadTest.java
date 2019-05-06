package com.zcy.manythread;

import com.zcy.ApacheCommons.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: George
 * @date: 2019/4/26
 * @description:
 */
public class LisThreadTest {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            Person person = new Person();
            list.add(person);
        }
        long s = System.currentTimeMillis();
        list.stream().forEach(l->l.setName("George"));
        long e = System.currentTimeMillis();
        System.out.println(e-s);//49

        long s1 = System.currentTimeMillis();
        list.parallelStream().forEach(l->l.setName("George"));
        long e1 = System.currentTimeMillis();
        System.out.println(e1-s1);//4

        int[] i = new int[10000000];
        for (int j = 0; j < 10000000; j++) {
            i[j] = j;
        }

        System.out.println("################################");
//        Arrays.stream(i).forEach(q->i[q]=1);
        long a1 = System.currentTimeMillis();
        Arrays.setAll(i,q->i[q]=3);
        System.out.println(i[999]);
        long a2 = System.currentTimeMillis();
        System.out.println(a2-a1);//12
        long a3 = System.currentTimeMillis();
        Arrays.parallelSetAll(i,q->i[q]=3);
        System.out.println(i[999]);
        long a4 = System.currentTimeMillis();
        System.out.println(a4-a3);//39
    }
}