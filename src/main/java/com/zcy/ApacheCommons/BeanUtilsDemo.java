package com.zcy.ApacheCommons;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: George
 * @date: 2019/4/18
 * @description:
 */
public class BeanUtilsDemo {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Person person = new Person();
        person.setAge(1);
        person.setName("george");

        Person clonePerson = (Person) BeanUtils.cloneBean(person);
        System.out.println(clonePerson.getAge());
        System.out.println(clonePerson.getName());

        Map m = new HashMap<>();
        m.put("age",15);
        m.put("name","Lucy");
        BeanUtils.populate(clonePerson,m);
        System.out.println(clonePerson.getName());
        Map<String, String> describe = BeanUtils.describe(clonePerson);
        System.out.println(describe.get("name"));
    }
}