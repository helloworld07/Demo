package com.zcy.onepeightnew;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @author: George
 * @date: 2019/4/17
 * @description:
 */
public class ClocksDemo {
    public static void main(String[] args) {
        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock.millis());
        System.out.println(clock.instant());
        System.out.println(Date.from(clock.instant()));

        LocalDate now = LocalDate.now();
        System.out.println(now);
        LocalDate plus = now.plus(1, ChronoUnit.DAYS);
        LocalDate minus = now.minus(1, ChronoUnit.DAYS);
        System.out.println(plus);
        System.out.println(minus);

        LocalDateTime now1 = LocalDateTime.now();
        System.out.println(now1);

        /*java.sql.Date sdate = java.sql.Date.valueOf("2019-04-24");
        java.sql.Date edate = java.sql.Date.valueOf("2019-04-01");
        while (edate.before(sdate)) {
            //循环向前推一天
            LocalDate localDate = sdate.toLocalDate();
            sdate = java.sql.Date.valueOf(localDate.minus(1, ChronoUnit.DAYS));
            System.out.println(sdate);
        }*/

        // 取当前日期
        LocalDate today = LocalDate.now();
        System.out.println(today);

        // 获得2005年的第86天 (27-Mar-2005)
        LocalDate localDate = LocalDate.ofYearDay(2005, 86);
        System.out.println(localDate);

        // 根据年月日取日期 2013年8月10日
        System.out.println(LocalDate.of(2013, Month.AUGUST, 10));
        System.out.println(LocalDate.of(2013, 8, 10));

        System.out.println(LocalDate.parse("2014-02-28"));// 严格按照ISO yyyy-MM-dd验证，02写成2都不行

        // 取下一天：
        LocalDate nextDayOfToday = today.plusDays(1);
        System.out.println(nextDayOfToday);
    }
}