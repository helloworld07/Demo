package com.zcy.Guava;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @author: George
 * @date: 2019/9/10
 * @description:
 */
public class BloomFilterTest {
    public static void main(String[] args) {
        long expectedInsertions = 10000000;//需要计算
        double fpp = 0.00001;//需要计算

        BloomFilter<CharSequence> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), expectedInsertions, fpp);

        bloomFilter.put("aaa");
        bloomFilter.put("bbb");
        boolean containsString = bloomFilter.mightContain("aaa");
        System.out.println(containsString);
    }
}