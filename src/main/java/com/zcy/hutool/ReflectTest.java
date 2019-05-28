package com.zcy.hutool;

import cn.hutool.core.util.ReflectUtil;
import com.zcy.proxy.Student;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: George
 * @date: 2019/5/14
 * @description:
 */
public class ReflectTest {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Method[] method = ReflectUtil.getMethods(Student.class);
        Method method1 = method[1];//获取方法
        Student student = new Student();
        method1.invoke(student,"qweqwe");//使用方法
//        Student student = ReflectUtil.newInstance(Student.class);
//        student.setName("qqqqq");
        System.out.println(student.getName());


    }
}