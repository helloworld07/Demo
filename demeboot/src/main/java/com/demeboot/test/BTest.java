package com.demeboot.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class BTest {
    @Autowired
    private ATest aTest;

    @RequestMapping("geta")
    public String methodA(){
        int a = aTest.add(1);
        int b = aTest.add(1);
        int c = aTest.add(1);
        return a + "/" + b + "/" + c;
    }

    @RequestMapping("getb")
    public String methodB(){
        ATest aTest = new ATest();
        int a = aTest.add(1);
        int b = aTest.add(1);
        int c = aTest.add(1);
        return a + "/" + b + "/" + c;
    }

}
