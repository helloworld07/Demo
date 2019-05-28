package com.zcy.proxy;

public class Student implements Person{
    private String name;
    public Student(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }
    public Student() {

    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void giveMoney(){
        System.out.println("give money!");
    }
}
