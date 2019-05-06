package com.zcy.date;

import com.zcy.util.ObjSize;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: George
 * @date: 2019/4/9
 * @description:
 */
public class ObjectSizeTest {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("123");
        int i = ObjSize.sizeOfObj(sb);
        System.out.println(i);
        System.out.println(sb);
    }
}