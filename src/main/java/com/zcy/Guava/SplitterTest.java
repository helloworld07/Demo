package com.zcy.Guava;

import com.google.common.base.Splitter;

/**
 * @author: George
 * @date: 2019/9/3
 * @description:
 */
public class SplitterTest {
    public static void main(String[] args) {
        System.out.println(Splitter.on(",").limit(3).trimResults().split("a,b,c,d"));//[ a, b, c,d]
        System.out.println(Splitter.fixedLength(3).split("1 2 3"));//[1 2,  3]
        System.out.println(Splitter.on(" ").omitEmptyStrings().splitToList("1  2 3"));
        System.out.println(Splitter.on(",").omitEmptyStrings().split("1,,,,2,,,3"));//[1, 2, 3]
        System.out.println(Splitter.on(" ").trimResults().split("1 2 3")); //[1, 2, 3],默认的连接符是,
        System.out.println(Splitter.on(";").withKeyValueSeparator(":").split("a:1;b:2;c:3"));//{a=1, b=2, c=3}
    }
}