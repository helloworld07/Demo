package com.zcy;

import com.zcy.ApacheCommons.Person;

/**
 * @author: George
 * @date: 2019/10/10
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        getPerson(person);
        System.out.println(person);
        int a = 0;
        getInt(a);
        System.out.println(a);
    }

    public static Person getPerson(Person person){
        person.setName("george");
        person.setAge(18);
        return person;
    }

    public static int getInt(int a){
        a = 10;
        return a;
    }
}