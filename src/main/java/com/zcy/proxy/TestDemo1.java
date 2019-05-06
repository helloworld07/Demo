package com.zcy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestDemo1 {
    public static void main(String[] args) {
        Student zhangsan = new Student("zhangsan");
        InvocationHandler stuHandler = new StuInvocationHandler<Person>(zhangsan);

        Person stuProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class}, stuHandler);
        stuProxy.giveMoney();
    }
}
