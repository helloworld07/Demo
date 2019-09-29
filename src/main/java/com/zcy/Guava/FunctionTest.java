package com.zcy.Guava;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Preconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author: George
 * @date: 2019/9/4
 * @description:
 */
public class FunctionTest {
    public static void main(String[] args) {
        ArrayList<String> strings = Lists.newArrayList("abcde", "good", "qq", "longstory");
        Function<String, String> function1 = new Function<String, String>() {
            @Nullable
            @Override
            public String apply(@Nullable String input) {
                return input.length() > 5 ? input.substring(0, 5) : input;
            }
        };
        Function<String, String> function2 = new Function<String, String>() {
            @Nullable
            @Override
            public String apply(@Nullable String input) {
                return input.toUpperCase();
            }
        };
        Function<String, String> compose = Functions.compose(function1, function2);
        Collection<String> result = Collections2.transform(strings, compose);
        System.out.println(result);
    }
}