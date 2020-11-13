package com.zcy.ApacheCommons;

import java.util.Date;

/**
 * @author: George
 * @date: 2019/4/18
 * @description:
 */
public class Person {
    public String name;
    public int age;
    public Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}