package com.zcy.forCircleNewObject;

/**
 * @author: George
 * @date: 2019/5/29
 * @description:
 */
public class ForCircleTest {
    //在超大对象，超多循环的基础上，for循环外建对象速度上会有优势，但未测试在空间效率！
    public static void main(String[] args) {
        System.out.println("begin samll");
        //小对象赋值效率-->时间上来说差距真不大，空间上来说，第一种可以及时GC，性能估计会更好吧
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            SmallObject smallObject = new SmallObject();
            smallObject.setAge(15);
            smallObject.setName("Piter");
        }
        long end = System.currentTimeMillis();
        System.out.println("in:"+(end-start));//3607
        long start1 = System.currentTimeMillis();
        SmallObject smallObject = null;
        for (int i = 0; i < 100000000; i++) {
            smallObject = new SmallObject();
            smallObject.setAge(1);
            smallObject.setName("Piter");
        }
        long end1 = System.currentTimeMillis();
        System.out.println("out:"+(end1-start1));//3007
        System.out.println("end small");
        System.out.println("#########################");
        System.out.println("begin large");
        //大对象效率-->时间差距进一步拉大，for循环外的方式会好一些，但是牺牲了GC是否在全局效率上优于for循环内new对象？
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            LargeObject largeObject = new LargeObject();
            largeObject.setAddress("green blue red hat road,many way street");
            largeObject.setCity("New Yoak");
            largeObject.setJob("CPU Sender");
            largeObject.setName("Big Piter");
            largeObject.setNikename("papalala");
            largeObject.setPassword("qqqqq123123");
            largeObject.setTools("fist,gun");
        }
        long end2 = System.currentTimeMillis();//5260
        System.out.println("IN:"+(end2-start2));//
        long start3 = System.currentTimeMillis();
        LargeObject largeObject = null;
        for (int i = 0; i < 100000000; i++) {
            largeObject = new LargeObject();
            largeObject.setAddress("green blue red hat road,many way street");
            largeObject.setCity("New Yoak");
            largeObject.setJob("CPU Sender");
            largeObject.setName("Big Piter");
            largeObject.setNikename("papalala");
            largeObject.setPassword("qqqqq123123");
            largeObject.setTools("fist,gun");
        }
        long end3 = System.currentTimeMillis();
        System.out.println("OUT:"+(end3-start3));//4747
        System.out.println("end large");
    }
}