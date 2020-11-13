package com.zcy;

import com.zcy.ApacheCommons.Person;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.*;

/**
 * @author: George
 * @date: 2019/10/10
 * @description:
 */
public class Test {
    @SneakyThrows //lombok注解，抛出异常
    public static void main(String[] args) {
        List<Person> list = new ArrayList<Person>();
        Person person = new Person();
        person.setAge(11);
        person.setName("aba");
        list.add(person);
        person.setAge(25);
        person.setName("bbbbb");
        list.add(person);
        list.forEach(l-> System.out.println(l.getName()));
        System.out.println("==========================");
        List<String> list1 = new ArrayList<>();
        String s = "123";
        list1.add(s);
        s = "567";//相当于new了一个
        list1.add(s);
        list1.forEach(l-> System.out.println(l));
        System.out.println("==========================");
        List<Person> list2 = new ArrayList<>();
        List<Person> l = new ArrayList<>();
        Person p1 = new Person();
        p1.setName("hehehe");
        Person p2 = new Person();
        p2.setName("hahaha");
        l.add(p1);
        list2.addAll(l);
        l.remove(0);
        l.add(p2);
        list2.addAll(l);
        list2.forEach(l1-> System.out.println(l1.getName()));
        System.out.println("==========================");
        List<Person> listResult = new ArrayList<>();
        List<Person> list3 = new ArrayList<Person>();
        Person person3 = new Person();
        person3.setAge(11);
        person3.setName("aba");
        list3.add(person3);
        listResult.addAll(list3);
        person3.setAge(25);
        person3.setName("bbbbb");
        list3.add(person3);
        listResult.addAll(list3);
        list3.forEach(l3-> System.out.println(l3.getName()));




    }

}