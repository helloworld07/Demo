package com.demeboot.test;

import org.springframework.stereotype.Component;

@Component
public class ATest {
    int a = 1;
    public int add(int b){
        a = a+b;
        return a+b;
    }
}
