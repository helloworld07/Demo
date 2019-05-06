package com.zcy.hutool;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;

import java.awt.*;

/**
 * @author: George
 * @date: 2019/5/6
 * @description:
 */
public class CaptchaTest {
    public static void main(String[] args) {
        //定义图形验证码的长、宽、验证码字符数、干扰线宽度
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(200, 100, 4, 4);
        //ShearCaptcha captcha = new ShearCaptcha(200, 100, 4, 4);
        //图形验证码写出，可以写出到文件，也可以写出到流
        captcha.write("d:/shear.png");
        //验证图形验证码的有效性，返回boolean值
        boolean verify = captcha.verify("1234");
        System.out.println(verify);
    }
}