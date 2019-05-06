package com.zcy.ApacheCommons;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: George
 * @date: 2019/4/19
 * @description:
 */
public class StringUtilsDemo {
    public static void main(String[] args) {
        String s = StringUtils.substringAfter("1234567qwerzz", "456");
        System.out.println(s);

        System.out.println(RandomStringUtils.randomAlphanumeric(7));

        System.out.println(StringUtils.isBlank("   "));

        List list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(StringUtils.join(list,","));

        System.out.println(StringUtils.rightPad("123",7,"ab"));//123abab

        System.out.println(StringUtils.capitalize("abcdefg"));

        System.out.println(StringUtils.deleteWhitespace("ag  dd  332"));

        System.out.println(StringUtils.contains("abcdef","cd"));

        System.out.println(StringUtils.left("abcdefg",3));
    }
}