package com.zcy.onepeightnew;


import com.zcy.ApacheCommons.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author: George
 * @date: 2019/4/17
 * @description:
 */
public class OptionalsDemo {
    public static void main(String[] args) {
//        Optional<String> optional = Optional.of("qqq");
//        String s = optional.get();
//        System.out.println(s);
//        System.out.println(optional.isPresent());

        List<Person> l = new ArrayList<>();
        Person person = new Person();
        person.setName("George");
        person.setAge(1);
        l.add(person);
        Person person1 = new Person();
        person1.setName("Tina");
        person1.setAge(22);
        l.add(person1);
        Person person2 = new Person();
        person2.setName("Pagy");
        person2.setAge(90);
        l.add(person2);
        Person person3 = new Person();
        l.add(person3);

        List<Person> nol = null;

        //一般处理
        l.parallelStream().forEach(s -> System.out.println(s.getName()));
        //过滤list内的值
        l.parallelStream().filter(s -> s.getName() != null).forEach(s -> System.out.println(s.getName()));
        //先判断list是否为空，再做处理（若为空就不做处理了）
        Optional.ofNullable(nol).ifPresent(s -> s.parallelStream().forEach(a -> System.out.println(a.getName())));
    }
}