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
        System.out.println("begin");
        int a =6;
        assert a == 7;
        System.out.println(a);
        System.out.println("end");
    }
}