package com.zcy.hutool.Aop;

import cn.hutool.aop.aspects.SimpleAspect;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.lang.Console;

import java.lang.reflect.Method;

/**
 * @author: George
 * @date: 2019/8/16
 * @description:
 */
public class TimeAspect extends SimpleAspect {
    //TimeInterval为Hutool实现的一个计时器
    private TimeInterval interval = new TimeInterval();

    @Override
    public boolean before(Object target, Method method, Object[] args) {
        interval.start();
        return true;
    }

    @Override
    public boolean after(Object target, Method method, Object[] args) {
        Console.log("Method [{}.{}] execute spend [{}]ms", target.getClass().getName(), method.getName(), interval.intervalMs());
        return true;
    }
}