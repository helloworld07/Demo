package com.zcy.suanfa;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        QuicklySort quicklySort = new QuicklySort();
        int a[] = {2,44,6,22,88,1,0,5,10};
        quicklySort.quickSort(a);
        System.out.println(Arrays.toString(a));

    }
}
