package com.zcy.build;

import lombok.Builder;
import lombok.Singular;

import java.util.Set;

/**
 * @author: George
 * @date: 2020/2/11
 * @description:
 */
@Builder
public class BuilderTest {
    private String name;
    private int age;
    @Singular
    private Set<String> occupations;
    public static void main(String[] args) {
        BuilderTest test = BuilderTest.builder().age(11).name("test").build();
    }
}