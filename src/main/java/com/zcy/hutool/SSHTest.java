package com.zcy.hutool;

import cn.hutool.extra.ssh.JschUtil;
import com.jcraft.jsch.Session;

/**
 * @author: George
 * @date: 2019/8/16
 * @description:
 */
public class SSHTest {
    public static void main(String[] args) {
        Session session = JschUtil.getSession("39.100.110.91", 22, "bqroot", "9|MjCG+.dEYj'&4\\nQbM");
        boolean b = JschUtil.bindPort(session, "39.100.110.91", 3306, 7711);
        System.out.println(b);
        JschUtil.unBindPort(session,7711);
        JschUtil.close(session);
    }
}