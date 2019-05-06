package com.zcy.onepeightnew;

import com.zcy.proxy.Student;

import java.util.Objects;
import java.util.function.Function;

/**
 * @author: George
 * @date: 2019/4/17
 * @description: 自定义规则，Function<输入参数类型，返回参数类型>
 */
public class FunctionsDemo {
    public static void main(String[] args) {
        Function<String, Integer> toInterger = Integer::valueOf;//实现apply方法
        Integer apply = toInterger.apply("1234");
        System.out.println(apply);
        // 作用于下相同
        System.out.println(Integer.valueOf("1234"));

        Function<Object, Boolean> getNum = Objects::isNull;
        Student student = null;
        Boolean apply1 = getNum.apply(student);
        System.out.println(apply1);
    }
}