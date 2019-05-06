package com.zcy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author George
 */
public class StuInvocationHandler<T> implements InvocationHandler {

    T taget;

    public StuInvocationHandler(T taget) {
        this.taget = taget;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行"+method.getName()+"方法");
        Object invoke = method.invoke(taget, args);
        System.out.println("实现自己的想法");
        return invoke;
    }
}
