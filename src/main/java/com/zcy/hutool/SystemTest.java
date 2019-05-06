package com.zcy.hutool;

import cn.hutool.system.JvmSpecInfo;
import cn.hutool.system.RuntimeInfo;
import cn.hutool.system.SystemUtil;

/**
 * @author: George
 * @date: 2019/5/6
 * @description:
 */
public class SystemTest {
    public static void main(String[] args) {
        JvmSpecInfo jvmSpecInfo = SystemUtil.getJvmSpecInfo();
        System.out.println(jvmSpecInfo.toString());
        RuntimeInfo runtimeInfo = SystemUtil.getRuntimeInfo();
        System.out.println(runtimeInfo);
    }
}