package com.zcy.date;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        //一般使用
        LocalDateTime localDateTime = LocalDateTime.now();
        String format = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(format);
        //加减
        //这种加貌似日期上下午会有点问题
        LocalDateTime plus = localDateTime.plus(1, ChronoUnit.HALF_DAYS);
        System.out.println(plus.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        //这种是对的
        LocalDateTime localDateTime1 = localDateTime.plusDays(1);
        System.out.println(localDateTime1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        //互转
        //LocalDateTime转Date
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(date);
        //Date转LocalDateTime
        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault());
        System.out.println(localDateTime2);
    }
}
