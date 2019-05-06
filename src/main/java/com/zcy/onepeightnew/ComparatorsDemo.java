package com.zcy.onepeightnew;

import com.zcy.proxy.Student;

import java.util.Comparator;

/**
 * @author: George
 * @date: 2019/4/17
 * @description:
 */
public class ComparatorsDemo {
    public static void main(String[] args) {
        Comparator<Student> comparators = (p1, p2)->p1.getName().compareTo(p2.getName());
        Student s1 = new Student("d");
        Student s2 = new Student("a");
        int compare = comparators.compare(s1, s2);
        System.out.println(compare);
    }
}