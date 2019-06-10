package com.zcy.onepeightnew;

import java.util.ArrayList;
import java.util.Arrays;
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
        String[] r = new String[max];
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            String uuidStr = uuid.toString();
            values.add(uuidStr);
            r[i] = uuidStr;
        }

        long l0 = System.nanoTime();
        values.stream().sorted().count();
        long l1 = System.nanoTime();
        System.out.println(TimeUnit.NANOSECONDS.toMillis(l1 - l0));

        l0 = System.nanoTime();
        values.parallelStream().sorted().count();
        l1 = System.nanoTime();
        System.out.println(TimeUnit.NANOSECONDS.toMillis(l1 - l0));

        System.out.println("#####################################");

        l0 = System.currentTimeMillis();
        Arrays.parallelSort(r);
        l1 = System.currentTimeMillis();
        System.out.println(l1-l0);

        l0 = System.currentTimeMillis();
        Arrays.sort(r);
        l1 = System.currentTimeMillis();
        System.out.println(l1-l0);

    }
}