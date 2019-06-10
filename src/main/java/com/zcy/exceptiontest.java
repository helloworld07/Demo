package com.zcy;

/**
 * @author: George
 * @date: 2019/5/20
 * @description:
 */
public class exceptiontest {
    public static void main(String[] args) {
        Exception ex = null;
        try {
            int b = 1;
            try {
                int a = 1 / 0;
            } catch (Exception e) {
                System.out.println("first in catch");
//                e.printStackTrace();
                System.out.println(e.toString());
                ex = e;
            }
            int c = 2;
            System.out.println(c);
            throw ex;//抛出异常后后面的就不执行了
        } catch (Exception e) {
            System.out.println("second in catch");
//            e.printStackTrace();
            System.out.println(e.toString());
        }
    }
}