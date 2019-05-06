package com.zcy.onepeightnew;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

        java.sql.Date sdate = java.sql.Date.valueOf("2019-04-24");
        java.sql.Date edate = java.sql.Date.valueOf("2019-04-01");
        while (edate.before(sdate)) {
            //循环向前推一天
            LocalDate localDate = sdate.toLocalDate();
            sdate = java.sql.Date.valueOf(localDate.minus(1, ChronoUnit.DAYS));
            System.out.println(sdate);
        }
    }
}