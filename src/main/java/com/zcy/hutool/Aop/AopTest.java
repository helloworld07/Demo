package com.zcy.hutool.Aop;

import cn.hutool.aop.ProxyUtil;

/**
 * @author: George
 * @date: 2019/8/16
 * @description:
 */
public class AopTest {
    public static void main(String[] args) {
        //引入了Cglib依赖s
        Dog dog = ProxyUtil.proxy(new Dog(), TimeAspect.class);//直接在Dog类上加计时切面TimeAspect
        String sth = dog.eat();
        System.out.println(sth);
    }
}