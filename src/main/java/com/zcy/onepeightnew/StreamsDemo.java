package com.zcy.onepeightnew;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author: George
 * @date: 2019/4/17
 * @description:
 */
public class StreamsDemo {
    public static void main(String[] args) {
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        long l0 = System.nanoTime();
        values.stream().sorted().count();
        long l1 = System.nanoTime();
        System.out.println(TimeUnit.NANOSECONDS.toMillis(l1 - l0));

        l0 = System.nanoTime();
        values.parallelStream().sorted().count();
        l1 = System.nanoTime();
        System.out.println(TimeUnit.NANOSECONDS.toMillis(l1 - l0));
    }
}