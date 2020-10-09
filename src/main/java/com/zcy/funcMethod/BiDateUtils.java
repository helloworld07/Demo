package com.zcy.funcMethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BiDateUtils {
    //月初转换日初转换
    public static final SimpleDateFormat YMDSin1 = new SimpleDateFormat("yyyy-MM-dd");
    /** 时间格式(yyyy-MM-dd) */
    public final static String DATE_PATTERN_ = "yyyy-MM-dd";

    public final static String DATE_PATTERN = "yyyyMMdd";

    public final static String DATE_HOUR_PATTERN = "yyyyMMddHH";

    /** 时间格式(yyyy/MM/dd) */
    public final static String DATE_PATTERN_SLASH = "yyyy/MM/dd";

    /** 时间格式(yyyy-MM-dd HH:mm:ss) */
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    // @Fields today : 不可以直接取，设定private
    private static Date today;
    private static Date yesterday;

    public static Date getToday() {
        today = new Date();
        return today;
    }

    public static Date getYesterday() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getToday());
        // 把日期往前增加一天.整数往后推,负数往前移动
        calendar.add(Calendar.DATE, -1);
        // 这个时间就是表示昨天
        yesterday = calendar.getTime();
        return yesterday;
    }

    public static int getYearNum(Date begin, Date end) {
        Calendar be = Calendar.getInstance();
        be.setTime(begin);
        int y1 = be.get(Calendar.YEAR);

        Calendar en = Calendar.getInstance();
        en.setTime(end);
        int y2 = en.get(Calendar.YEAR);

        return (y2 - y1);
    }

    public static int getMonthNum(Date begin, Date end) {
        Calendar be = Calendar.getInstance();
        be.setTime(begin);
        int y1 = be.get(Calendar.YEAR);
        int m1 = be.get(Calendar.MONTH);
        Calendar en = Calendar.getInstance();
        en.setTime(end);
        int y2 = en.get(Calendar.YEAR);
        int m2 = be.get(Calendar.MONTH);
        return 12 * (y2 - y1) + (m2 - m1);
    }

    public static int getDayNum(Date begin, Date end) {
        Calendar be = Calendar.getInstance();
        be.setTime(begin);
        be.set(Calendar.HOUR, 0);
        be.set(Calendar.MINUTE, 0);
        be.set(Calendar.SECOND, 0);
        be.set(Calendar.MILLISECOND, 0);
        long beM = be.getTimeInMillis();

        Calendar en = Calendar.getInstance();
        en.setTime(end);
        en.set(Calendar.HOUR, 0);
        en.set(Calendar.MINUTE, 0);
        en.set(Calendar.SECOND, 0);
        en.set(Calendar.MILLISECOND, 0);
        long enM = en.getTimeInMillis();

        return (int) ((enM - beM) / (1000 * 60 * 60 * 24));
    }

    public static Date YMdparse(String dateStr) {
        Date date = null;
        try {
            SimpleDateFormat YMDSin2 = new SimpleDateFormat("yyyy/MM/dd");
            date = YMDSin2.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * @Function: DateUtils.java
     * @Description: 该函数的功能描述 获取指定数字的日期集合，如section为7，则返回从昨天算起的前七天的日期
     * @param:参数描述 指定时间区间
     * @return：返回结果描述 String类型的日期集合
     * @throws：异常描述
     * @version: v1.0.0
     * @author: FengCheng
     * @date: 2017年7月24日 上午11:44:13
     * <p>
     * Modification History: Date Author Version Description
     * ---------------------------------------------------------*
     * 2017年7月24日 FengCheng v1.0.0 修改原因
     */

    public static List<String> getRecentlyDate(int section) {
        Calendar calendar = Calendar.getInstance();
        getToday();
        Date date;
        String thatDay;
        List<String> recentlyDate = new ArrayList<String>();
        // 参数正转负
        section = section - 2 * section;
        for (int i = section; i < 0; i++) {
            calendar.setTime(today);
            calendar.add(Calendar.DATE, i);
            date = calendar.getTime();
            thatDay = getyyyyMMdd(date);
            recentlyDate.add(thatDay);
        }
        return recentlyDate;
    }
    //返回的时间格式为yyyy-mm-dd
    public static List<String> obtainRecentlyDate(int section) {
        Calendar calendar = Calendar.getInstance();
        getToday();
        Date date;
        String thatDay;
        List<String> recentlyDate = new ArrayList<String>();
        // 参数正转负
        section = section - 2 * section;
        for (int i = section; i < 0; i++) {
            calendar.setTime(today);
            calendar.add(Calendar.DATE, i);
            date = calendar.getTime();
            thatDay = gainyyyyMMdd(date);
            recentlyDate.add(thatDay);
        }
        return recentlyDate;
    }

    public static int getdd() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DATE);
    }

    /**
     * @return 0-11
     */
    public static int getMM() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH);
    }

    /**
     * @return 2017
     */
    public static int getyyyy() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }

    public static String getyyyyMMdd(Date date) {
        SimpleDateFormat byDay = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        return byDay.format(date);
    }

    public static String gainyyyyMMdd(Date date) {
        SimpleDateFormat byDay = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return byDay.format(date);
    }

    public static String dd(Date date) {
        SimpleDateFormat day = new SimpleDateFormat("dd", Locale.getDefault());
        return day.format(date);
    }

    public static String getyyyyMM(Date date) {
        SimpleDateFormat byMonth = new SimpleDateFormat("yyyyMM", Locale.getDefault());
        return byMonth.format(date);
    }

    public static String getMM(Date date) {
        SimpleDateFormat MONTH = new SimpleDateFormat("MM", Locale.getDefault());
        return MONTH.format(date);
    }

    /**
     * @param date
     * @return 117 1900 开始 2017 :117
     */
    public static String getyyyy(Date date) {
        SimpleDateFormat byYear = new SimpleDateFormat("yyyy", Locale.getDefault());
        return byYear.format(date);
    }

    public static Boolean isTheEndOfMonth(Date date) {
        int day = date.getDate();
        int month = date.getMonth();
        int year = date.getYear();
        int month2 = new Date(year, month, day + 1).getMonth();

        return !(month == month2);
    }

    /**
     * @param date
     * @return true :是第一天
     */
    public static Boolean isTheBeginOfMonth(Date date) {
        int day = date.getDate();
        return day == 1;
    }

    /**
     * @param date
     * @return true :不是最后一天
     */
    public static boolean isTheEndOfYear(Date date) {
        int day = date.getDate();
        int month = date.getYear();
        int year = date.getYear();
        int year2 = new Date(year, month + 1, day).getYear();

        return !(year == year2);
    }

    public static boolean sameyyyyMM(Date begin, Date end) {
        String getyyyyMM = BiDateUtils.getyyyyMM(begin);
        String getyyyyMM2 = BiDateUtils.getyyyyMM(end);
        return getyyyyMM.equals(getyyyyMM2);

    }

    @SuppressWarnings("deprecation")
    public static String getLastyyyyMM(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(Calendar.MONTH, -1);
        Date time = instance.getTime();
        String yM = getyyyyMM(time);
        return yM;
    }

    @SuppressWarnings("deprecation")
    public static String getLastyyyyMMdd(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(Calendar.DATE, -1);
        Date time = instance.getTime();
        String yM = getyyyyMMdd(time);
        return yM;
    }

    /**
     * 验证字符串是否是正确的日期格式;严格验证
     *
     * @param date
     * @return
     */
    public static boolean isDateType(String date) {
        SimpleDateFormat YMDSin1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat YMDSin2 = new SimpleDateFormat("yyyy/MM/dd");
        try {
            YMDSin2.setLenient(false);
            YMDSin2.parse(date);
            return true;
        } catch (ParseException e) {
            YMDSin1.setLenient(false);
            try {
                YMDSin1.parse(date);
                return true;
            } catch (ParseException e1) {
            }
        }
        return false;
    }

    /**
     * 传入日期大于当前日期的两个月前比较
     *
     * @param date
     * @return 日期在两个月之前返回true
     * @throws ParseException
     */
    public static boolean compareMonthsAgo(String date) throws ParseException {
        SimpleDateFormat YMDSin1 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -1);// 月份减一
        calendar.set(Calendar.DATE, 1);
        calendar.add(Calendar.DATE, -1);// 日期减一
        if (calendar.getTime().getTime() > YMDSin1.parse(date).getTime()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据字符串转为日期
     * simpleDateFormate是线程非安全的需要new
     *
     * @return
     * @throws ParseException
     */
    public static Date stringToDate(String date) {
        SimpleDateFormat YMDSin1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat YMDSin2 = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat mmySin = new SimpleDateFormat("mmm-yy");
        SimpleDateFormat byDay = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        try {
            return YMDSin1.parse(date);
        } catch (ParseException e) {
            try {
                return YMDSin2.parse(date);
            } catch (ParseException e1) {
                try {
                    return mmySin.parse(date);
                } catch (ParseException e2) {
                    try {
                        return byDay.parse(date);
                    } catch (ParseException e3) {
                        return null;
                    }
                }
            }
        }
    }

    /**
     * 日期转换为字符串yyyyMMddHHmmss
     *
     * @param date
     * @return
     */
    public static String dateToString(Date date) {
        SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return yyyyMMddHHmmss.format(date);
    }

    /**
     * @Author summer
     * @Date 2019-11-04 15:17
     * @Description string 类型转换成 Date yyyy-MM-dd HH:mm:ss 格式
     **/
    public static Date stringToDateSecond(String date) {
        SimpleDateFormat YMDSin1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return YMDSin1.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 日期转换为字符串yyyyMMdd
     *
     * @param date
     * @return
     */
    public static String dateToStringYMDSin(Date date) {
        SimpleDateFormat YMDSin2 = new SimpleDateFormat("yyyy-MM-dd");
        return YMDSin2.format(date);
    }

    /**
     * 日期转换为字符串yyyy-MM-dd HH
     *
     * @param date
     * @return
     */
    public static String dateToStringYMDSinHour(Date date) {
        SimpleDateFormat YMDSin2 = new SimpleDateFormat("yyyy-MM-dd HH:00:00");
        return YMDSin2.format(date);
    }

    /**
     * 返回字符串的当月一号
     *
     * @param date
     * @return
     */
    public static String stringToMontYear(String date) {
        SimpleDateFormat YMDSin1 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(stringToDate(date));
        calendar.set(Calendar.DATE, 1);
        return YMDSin1.format(calendar.getTime());
    }

    /**
     * 字符串当前日期加day
     *
     * @param date
     * @param day
     * @return
     */
    public static String stringDateAddDay(String date, int day) {
        SimpleDateFormat YMDSin1 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(stringToDate(date));
        calendar.add(Calendar.DATE, day);
        return YMDSin1.format(calendar.getTime());
    }

    /**
     * 字符串当前日期加hour
     *
     * @param date
     * @return
     */
    public static String stringDateAddHour(String date, int hour) {
        SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(stringToDate(date));
        calendar.add(Calendar.HOUR, hour);
        Date a = calendar.getTime();
        return yyyyMMddHHmmss.format(calendar.getTime());
    }

    public static String stringDateTimeAddHour(String date, int hour) {
        SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(stringToDateSecond(date));
        calendar.add(Calendar.HOUR, hour);
        Date a = calendar.getTime();
        return yyyyMMddHHmmss.format(calendar.getTime());
    }

    public static void main(String[] args) {
        System.out.println(stringDateAddHour("2017-01-01", 1));
    }

    /**
     * @return Date
     * @throws ParseException
     * @throws Date           Author          Version            Description
     *                        ---------------------------------------------------------
     *                        2017年9月27日      Jared           v1.0.0
     * @Function: getTestNow
     * @Description:测试使用当前时间
     */
    public static Date getTestNow() throws ParseException {
        return new Date();
    }

    /**
     * @param date
     * @return Date
     * @throws ParseException
     * @throws Date           Author          Version            Description
     *                        ---------------------------------------------------------
     *                        2017年10月12日      Jared           v1.0.0
     * @Function: zeroSetting
     * @Description:将日期设值为00:00:00
     */
    public static Date firstTimeOfDay(Date date) {
        SimpleDateFormat firstTimeOfDay = new SimpleDateFormat("yyyy-MM-dd 00:00:00 000");
        try {
            return firstTimeOfDay.parse(firstTimeOfDay.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
            return date;
        }
    }

    /**
     * 将日期设值为 23:59:59
     *
     * @param date
     * @return
     */
    public static Date endTimeOfDay(Date date) {
        try {
            SimpleDateFormat endTimeOfDay = new SimpleDateFormat("yyyy-MM-dd 23:59:59 999");
            SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
            return yyyyMMddHHmmss.parse(endTimeOfDay.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
            return date;
        }
    }

    public static Date firstDayOfMonth(Date date) {
        SimpleDateFormat firstDayOfMonth = new SimpleDateFormat("yyyy-MM-01 00:00:00 000");
        try {
            return firstDayOfMonth.parse(firstDayOfMonth.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
            return date;
        }
    }

    /**
     * 日期加day
     *
     * @param date
     * @param day
     * @return
     */
    public static Date dateAddDay(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);
        return calendar.getTime();
    }

    /**
     * 日期加月
     *
     * @param date
     * @return
     */
    public static Date dateAddMonth(Date date, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }

    /**
     * 日期加年
     *
     * @param date
     * @return
     */
    public static Date dateAddYear(Date date, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, year);
        return calendar.getTime();
    }

    /**
     * 日期加毫秒数
     *
     * @param date
     * @return
     */
    public static Date dateAddMilliSecond(Date date, int MILLISECOND) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MILLISECOND, MILLISECOND);
        return calendar.getTime();
    }

    /**
     * @param startDate
     * @param endDate
     * @return Date
     * @throws Date Author          Version            Description
     *              ---------------------------------------------------------
     *              2017年12月23日      Jared           v1.0.0
     * @Function: getMidDate
     * @Description:返回开始结束时间的中间时间
     */
    public static Date getMidDate(Date startDate, Date endDate) {
        Long startTime = startDate.getTime();
        Long endTime = endDate.getTime();
        Long midTime = (startTime + endTime) / 2;
        Date midDate = new Date();
        midDate.setTime(midTime);
        return midDate;
    }

    /**
     * 字符串当前日期加分钟MINUTE
     *
     * @param date
     * @return
     */
    public static Date dateAddMinute(Date date, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minute);
        return calendar.getTime();
    }

    public static Date parse(String str, SimpleDateFormat format) {
        Date parse = null;
        try {
            parse = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }

    public static String format(Date date, SimpleDateFormat format) {
        return format.format(date);
    }

    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String format = simpleDateFormat.format(date);
        return format;
    }

    /**
     * 获取指定日期当月的第一天
     * @param date
     * @return
     */
    public static Date getFirstDayOfGivenMonth(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.add(Calendar.MONTH, 0);
        return calendar.getTime();
    }

    /**
     * 获取当前日期是星期几<br>
     *
     * @param dt
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"日", "一", "二", "三", "四", "五", "六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;

        return weekDays[w];
    }

    /**
     * 根据开始时间和结束时间返回时间段内的时间集合
     * @param startTime,endTime
     * @Return List<String>
     */
    public static List<String> getDatesBetweenTwoDate(String startTime,String endTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<String> lDate = new ArrayList<>();
        lDate.add(startTime);//把开始时间加入集合
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(startTime));
            while (true) {
                cal.add(Calendar.DAY_OF_MONTH, 1);
                if (sdf.parse(endTime).after(cal.getTime())) {
                    lDate.add(sdf.format(cal.getTime()));
                }else {
                    break;
                }
            }
        }catch (ParseException e){
            e.printStackTrace();
        }
        lDate.add(endTime);
        return lDate;
    }

    /**
     * 根据开始时间和结束时间返回时间段内的时间集合
     * @param beginDate,endDate
     * @Return List<Date>
     */
    public static List<Date> getDatesBetweenTwoDateWithDate(Date beginDate, Date endDate) {
        List<Date> lDate = new ArrayList<>();
        lDate.add(beginDate);// 把开始时间加入集合
        Calendar cal = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        cal.setTime(beginDate);
        while (true) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            cal.add(Calendar.DAY_OF_MONTH, 1);
            // 测试此日期是否在指定日期之后
            if (endDate.after(cal.getTime())) {
                lDate.add(cal.getTime());
            } else {
                break;
            }
        }
        lDate.add(endDate);// 把结束时间加入集合
        return lDate;
    }

    public static long getDiffTime(String before,String after) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long NTime =df.parse(after).getTime();
        //从对象中拿到时间
        long OTime = df.parse(before).getTime();
        long diff=(NTime-OTime);
        return diff;
    }

    /**
     * 功能描述: <br>
     * 〈获取指定日期的上个月的第一天日期，关键词：上月，上个月，1号〉
     * @Param: [date]
     * @Return: java.util.Date
     * @Author: King
     * @Date: 2020/5/19 16:03
     */
    public static String getFirstDayOfLastMonth(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return sdf.format(cal.getTime());
    }

    /**
     * 功能描述: <br>
     * 〈获取指定日期的上个月的最后一天日期，关键词：上月，上个月，最后一天〉
     * @Param: [date]
     * @Return: java.lang.String
     * @Author: King
     * @Date: 2020/5/19 16:11
     */
    public static String getLastDayOfLastMonth(Date date){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal=Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH,-1);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return sdf.format(cal.getTime());
    }

    /**
     * 功能描述: <br>
     * 〈获取指定日期所在月的最后一天，关键词：最后〉
     * @Param: [date]
     * @Return: java.lang.String
     * @Author: King
     * @Date: 2020/5/20 10:17
     */
    public static String getLastDayOfCurrentMonth(Date date){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal=Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH,1);
        cal.setTime(getFirstDayOfGivenMonth(cal.getTime()));
        cal.add(Calendar.DAY_OF_MONTH,-1);
        return sdf.format(cal.getTime());
    }

    /**
     * @author King
     * @description : 获取两个时间的时间差，单位：日
     * @date 2020/7/13 22:01
     */
    public static int getDateDifference(Date startDate,Date endDate){
        return (int)(startDate.getTime()-endDate.getTime())/(1000 * 60 * 60 * 24);
    }
}
