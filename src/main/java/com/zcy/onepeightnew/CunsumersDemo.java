package com.zcy.onepeightnew;

import com.zcy.proxy.Student;

import java.util.function.Consumer;

/**
 * @author: George
 * @date: 2019/4/17
 * @description:
 */
public class CunsumersDemo {
    public static void main(String[] args) {
        Consumer<Student> consumer = (p)-> System.out.println("hello"+p.getName());
        consumer.accept(new Student("qqq"));
    }
}