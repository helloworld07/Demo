package com.zcy;

/**
 * @author: George
 * @date: 2019/5/20
 * @description:
 */
public class exceptiontest {
    public static void main(String[] args) {
        try {
            int b = 1;
            try {
                int a = 1 / 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
            int c = 2;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}