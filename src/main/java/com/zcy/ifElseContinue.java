package com.zcy;

/**
 * @author: George
 * @date: 2019/6/5
 * @description:  ifelse与continue编译后class文件相同！
 */
public class ifElseContinue {
    public static void main(String[] args) {
        int a = 0;
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 50000000; i++) {
            if (i/2==0){
                a = a*i*i;
                continue;
            }
            a = a*i;
        }
        System.out.println(System.currentTimeMillis()-begin);

        long begin2 = System.currentTimeMillis();
        for (int i = 0; i < 50000000; i++) {
            if (i/2==0){
                a = a*i*i;
            }else {
                a=a*i;
            }
        }
        System.out.println(System.currentTimeMillis()-begin2);
    }
}