package com.zcy.itf;

import java.util.Map;

/**
 * @author: George
 * @date: 2019/4/16
 * @description:
 */
public interface testInterface {
    double caculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }

}