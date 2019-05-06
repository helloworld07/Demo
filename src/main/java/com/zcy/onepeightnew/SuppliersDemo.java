package com.zcy.onepeightnew;

import com.zcy.proxy.Student;

import java.util.function.Supplier;

/**
 * @author: George
 * @date: 2019/4/17
 * @description: 只有返回类型的function
 */
public class SuppliersDemo {
    public static void main(String[] args) {
        Supplier<Integer> supplier = StaticObjectDemo::getN;
        Integer i = supplier.get();
        System.out.println(i);
    }
}