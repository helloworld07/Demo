package com.zcy.Guava;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: George
 * @date: 2019/9/3
 * @description: Preconditions它检查的先决条件。其方法失败抛出IllegalArgumentException
 */
public class PreconditionsTest {
    public static void main(String[] args) {
        getValues(4);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(99);
        getNum(list);
    }

    public static boolean getValues(int a) {
        //处理方法前可以先做条件判断，若不符合直接抛出异常
        Preconditions.checkArgument(a > 3, "error number %s is not bigger than three", a);
        return true;
    }

    private static void getNum(List<Integer> list) {
        Preconditions.checkElementIndex(2,2,"Invalid index");
    }
}