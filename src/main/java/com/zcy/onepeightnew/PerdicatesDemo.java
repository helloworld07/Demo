package com.zcy.onepeightnew;

import com.zcy.proxy.Student;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author: George
 * @date: 2019/4/17
 * @description: Predicate接口，自定义判断规则，用test()判断
 */
public class PerdicatesDemo {
    public static void main(String[] args) {
        Predicate<String> predicate = (s) -> s.length() > 5;//实现test方法
        boolean test = predicate.test("123456");
        System.out.println(test);//true

        Predicate<Object> nonNull = Objects::nonNull;
        Student student = new Student("zhangshan");
        Student student1 = null;
        boolean test1 = nonNull.test(student1);
        System.out.println(test1);

        Predicate<String> isEmpty = String::isEmpty;
        boolean test2 = isEmpty.negate().test("123");
        System.out.println(test2);

        Predicate<String> pre = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length()>5;
            }
        };
    }
}