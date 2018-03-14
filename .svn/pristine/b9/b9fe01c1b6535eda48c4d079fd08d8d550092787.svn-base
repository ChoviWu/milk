package com.xw.milk.util;


import org.apache.commons.lang3.time.DateFormatUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    private static final String TIME_OF_DAY_BEGIN = " 00:00:00";
    private static final String TIME_OF_DAY_END = " 23:59:59";

    private static String[] parsePatterns = {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss"};

    private static Date startTime = null;       //起始时间
    private static Date nextStartTime = null;   //下一个起始时间


    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd）
     */
    public static String getDate() {
        return getDate("yyyy-MM-dd");
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String getDate(String pattern) {
        return DateFormatUtils.format(new Date(), pattern);
    }

    /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     *
     * @param pattern 时间格式
     */
    public static String formatDate(Date date, Object... pattern) {
        String formatDate = null;
        if (pattern != null && pattern.length > 0) {
            formatDate = DateFormatUtils.format(date, pattern[0].toString());
        } else {
            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
        }
        return formatDate;
    }

    /**
     * 得到当前时间字符串 格式（HH:mm:ss）
     */
    public static String getTime() {
        return formatDate(new Date(), "HH:mm:ss");
    }

    /**
     * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String getDateTime() {
        return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到当前年份字符串 格式（yyyy）
     */
    public static String getYear() {
        return formatDate(new Date(), "yyyy");
    }

    /**
     * 得到当前月份字符串 格式（MM）
     */
    public static String getMonth() {
        return formatDate(new Date(), "MM");
    }
    /**
     * 得到当天字符串 格式（dd）
     */
    public static String getDay() {
        return formatDate(new Date(), "dd");
    }
    /**
     * 得到当天字符串 格式（dd）
     */
    public static String getDay(Date date) {
        return formatDate(date, "dd");
    }
    /**
     * 得到当前星期字符串 格式（E）星期几
     */
    public static String getWeek() {
        return formatDate(new Date(), "E");
    }

    /**
     * 日期型字符串转化为日期 格式（"yyyy-MM-dd","yyyy/MM/dd"）
     */
    public static Date parseDate(String str) {
        try {
            return parseDate(str, parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取过去的天数
     *
     * @param date
     * @return
     */
    public static long pastDays(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (24 * 60 * 60 * 1000);
    }

    /**
     * 获取系统当前时间戳-秒数
     *
     * @return 自 1970 年 1 月 1 日 00:00:00 GMT 以来此日期表示的秒数。
     */
    public static long getTimeStampSeconds() {
        return new Date().getTime() / 1000;
    }

    /**
     * 获取系统当前时间戳-秒数
     *
     * @return 自 1970 年 1 月 1 日 00:00:00 GMT 以来此日期表示的秒数。
     */
    public static String getCurrTimeStampString() {
        return String.valueOf(getTimeStampSeconds());
    }

    /**
     * 获取指定时间的时间戳-秒数
     *
     * @param date
     * @return 自 1970 年 1 月 1 日 00:00:00 GMT 以来此日期表示的秒数。
     */
    public static long getTimeStampSeconds(Date date) {
        return (date.getTime() / 1000);
    }

    /**
     * 时间戳(秒数)转换为时间
     *
     * @param timeStamp 十位数
     * @return
     */
    public static Date getDate(long timeStamp) {
        Date date = new Date();
        date.setTime(timeStamp * 1000);
        return date;
    }

    /**
     * 时间戳转换为时间字符串
     *
     * @param timeStamp 十位数
     * @param pattern   时间格式
     * @return
     */
    public static String getDateString(long timeStamp, Object... pattern) {
        return formatDate(getDate(timeStamp), pattern);
    }


    /**
     * 时间戳转换为时间字符串，默认输出格式为：yyyy-MM-dd HH:mm:ss
     *
     * @param timeStamp 十位数字符串
     * @return
     */
    public static String getDateString(String timeStamp) {
        if (timeStamp == null || "".equals(timeStamp)) {
            return "";
        }
        return getDateString(Long.valueOf(timeStamp), parsePatterns[1]);
    }

    /**
     * 时间戳转换为时间字符串，默认输出格式为：yyyy-MM-dd
     *
     * @param timeStamp 十位数字符串
     * @return
     */
    public static String getSimpleDateString(String timeStamp) {
        if (timeStamp == null || "".equals(timeStamp)) {
            return "";
        }
        return getDateString(Long.valueOf(timeStamp), parsePatterns[0]);
    }

    /**
     * 获取系统当前时间的秒位时间戳
     *
     * @return
     */
    public static int getDateLong() {
        return (int) (new Date().getTime() / 1000);
    }

    /**
     * @param now
     * @param days
     * @return 字符串
     */
    public static String addDays(String now, int days) {
        Date nowDate = DateUtils.getDate(Long.valueOf(now));
        Date newDate = DateUtils.addDays(nowDate, days);
        return String.valueOf(getTimeStampSeconds(newDate));
    }

    public static String addMonths(String now, int months) {
        Date nowDate = DateUtils.getDate(Long.valueOf(now));
        Date newDate = DateUtils.addMonths(nowDate, months);
        return String.valueOf(getTimeStampSeconds(newDate));
    }

//    public static Date addTime(int type, Date nowDate, int amount) {
//        Date retDate = nowDate;
//        if (CycleUnit.DAY == type) {
//            retDate = DateUtils.addDays(nowDate, amount);
//        } else if (CycleUnit.MONTH == type) {
//            retDate = DateUtils.addMonths(nowDate, amount);
//        } else if (CycleUnit.SEASON == type) {
//            retDate = DateUtils.addMonths(nowDate, amount * 3);
//        } else if (CycleUnit.YEAR == type) {
//            retDate = DateUtils.addYears(nowDate, amount);
//        }
//        return retDate;
//    }

    public static Date setDayZero(Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        return cal.getTime();
    }

    public static Date setDayLast(Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.HOUR_OF_DAY, 23);
//        cal.set(Calendar.MILLISECOND,999);
        return cal.getTime();
    }


    /**
     * 获取昨日日期 返回格式：yyyy-MM-dd hh:mi:ss
     */
    public static Timestamp getBeginTimeOfDate(String beginDate) {
        return Timestamp.valueOf(beginDate + TIME_OF_DAY_BEGIN);
    }

    /**
     * 获取明天日期 返回格式：yyyy-MM-dd hh:mi:ss
     */
    public static Timestamp getEndTimeOfDate(String endDate) {
        return Timestamp.valueOf(endDate + TIME_OF_DAY_END);
    }

    /**
     * 当天起始时间
     * @return
     */
    public static Date getLastDayStartTime(Date date){
        Calendar lastDay = Calendar.getInstance();
        lastDay.setTime(date);
        lastDay.add(Calendar.DATE, -1);
        lastDay.set(Calendar.HOUR_OF_DAY, 0);    //获取当天小时并至0
        lastDay.set(Calendar.MINUTE, 0);          //分至0
        lastDay.set(Calendar.SECOND, 0);          //秒至0
        lastDay.set(Calendar.MILLISECOND, 0);    //毫秒至0
        startTime = lastDay.getTime();
        return startTime;
    }

    /**
     * 当天起始时间
     * @return
     */
    public static Date getDayStartTime(Date date){
        Calendar today = Calendar.getInstance();
        today.setTime(date);
        today.set(Calendar.HOUR_OF_DAY, 0);    //获取当天小时并至0
        today.set(Calendar.MINUTE, 0);          //分至0
        today.set(Calendar.SECOND, 0);          //秒至0
        today.set(Calendar.MILLISECOND, 0);    //毫秒至0
        startTime = today.getTime();

        return startTime;
    }
    /**
     * 第二天起始时间
     * @return
     */
    public static Date getNextDayStartTime(Date date){
        Calendar today = Calendar.getInstance();
        today.setTime(date);
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);

        today.add(Calendar.DATE, 1);			 //当天起始时间加1天

        nextStartTime = today.getTime();

        return nextStartTime;
    }
    /**
     * 本周第一天起始时间
     * @return
     */
    public static Date getWeekStartTime(Date date){
        Calendar weekStart = Calendar.getInstance();
        weekStart.setTime(date);
        if(weekStart.get(weekStart.DAY_OF_WEEK)==Calendar.SUNDAY){
            weekStart.add(Calendar.WEEK_OF_YEAR, -1);
        }
        weekStart.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);   //获取本周第一天
        weekStart.set(Calendar.HOUR_OF_DAY, 0);
        weekStart.set(Calendar.MINUTE, 0);
        weekStart.set(Calendar.SECOND, 0);
        weekStart.set(Calendar.MILLISECOND, 0);

        Date startTime = weekStart.getTime();

        return startTime;
    }
    /**
     * 下周第一天起始时间
     * @return
     */
    public static Date getNextWeekStartTime(Date date){
        Calendar weekStart = Calendar.getInstance();
        weekStart.setTime(date);
        if(weekStart.get(weekStart.DAY_OF_WEEK)== Calendar.SUNDAY){
            weekStart.add(Calendar.WEEK_OF_YEAR, -1);
        }
        weekStart.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);   //获取本周第一天
        weekStart.set(Calendar.HOUR_OF_DAY, 0);
        weekStart.set(Calendar.MINUTE, 0);
        weekStart.set(Calendar.SECOND, 0);
        weekStart.set(Calendar.MILLISECOND, 0);

        weekStart.add(Calendar.WEDNESDAY, 1);	                   //本周第一天加1周

        Date nextStartTime = weekStart.getTime();

        return nextStartTime;
    }
    /**
     * 当月第一天起始时间
     * @return
     */
    public static Date getMonthStartTime(Date date){
        Calendar monthStart = Calendar.getInstance();
        monthStart.setTime(date);
        monthStart.set(Calendar.DAY_OF_MONTH, 1);	//获取本月第一天
        monthStart.set(Calendar.HOUR_OF_DAY, 0);	//将小时至0
        monthStart.set(Calendar.MINUTE, 0);  		//将分钟至0
        monthStart.set(Calendar.SECOND, 0);  		//将秒至0
        monthStart.set(Calendar.MILLISECOND, 0);	//将毫秒至0

        startTime = monthStart.getTime();

        return startTime;
    }
    /**
     * 下个月第一天起始时间
     * @return
     */
    public static Date getNextMonthStartTime(Date date){
        Calendar monthStart = Calendar.getInstance();
        monthStart.setTime(date);
        monthStart.set(Calendar.DAY_OF_MONTH, 1);	//获取本月第一天
        monthStart.set(Calendar.HOUR_OF_DAY, 0);
        monthStart.set(Calendar.MINUTE, 0);
        monthStart.set(Calendar.SECOND, 0);
        monthStart.set(Calendar.MILLISECOND, 0);

        monthStart.add(Calendar.MONTH, 1);         //本月第一天加一个月

        nextStartTime = monthStart.getTime();

        return nextStartTime;
    }

    /**
     * 上个月第一天起始时间
     * @return
     */
    public static Date getLastMonthStartTime(Date date){
        Calendar monthStart = Calendar.getInstance();
        monthStart.setTime(date);
        monthStart.set(Calendar.DAY_OF_MONTH, 1);	//获取本月第一天
        monthStart.set(Calendar.HOUR_OF_DAY, 0);
        monthStart.set(Calendar.MINUTE, 0);
        monthStart.set(Calendar.SECOND, 0);
        monthStart.set(Calendar.MILLISECOND, 0);

        monthStart.add(Calendar.MONTH, -1);         //本月第一天减一个月

        nextStartTime = monthStart.getTime();

        return nextStartTime;
    }
    /**
     * 当年第一天起始时间
     * @return
     */
    public static Date getYearStartTime(Date date){

        Calendar yearStart = Calendar.getInstance();
        yearStart.setTime(date);
        yearStart.set(Calendar.DAY_OF_YEAR, 1);    //本年第一天
        yearStart.set(Calendar.HOUR_OF_DAY, 0);
        yearStart.set(Calendar.MINUTE, 0);
        yearStart.set(Calendar.SECOND, 0);
        yearStart.set(Calendar.MILLISECOND, 0);

        startTime = yearStart.getTime();

        return startTime;
    }
    /**
     * 下一年第一天起始时间
     * @return
     */
    public static Date getNextYearStartTime(Date date){

        Calendar yearStart = Calendar.getInstance();
        yearStart.setTime(date);
        yearStart.set(Calendar.DAY_OF_YEAR, 1);    //本年第一天
        yearStart.set(Calendar.HOUR_OF_DAY, 0);
        yearStart.set(Calendar.MINUTE, 0);
        yearStart.set(Calendar.SECOND, 0);
        yearStart.set(Calendar.MILLISECOND, 0);

        yearStart.add(Calendar.YEAR, 1);            //当年第一天加一年

        nextStartTime = yearStart.getTime();

        return nextStartTime;
    }

    public static Map<String,Object> getDateRegion(String groupType, Date date){
        Map<String, Object> statMap = new HashMap<String,Object>();
        if(groupType.equals("day")){
            statMap.put("groupType", "day");
            statMap.put("startTime", DateUtils.getDayStartTime(date));        //当天开始时间
            statMap.put("endTime", DateUtils.getNextDayStartTime(date));
        }
        else if(groupType.equals("week")){
            statMap.put("groupType", "week");
            statMap.put("startTime", DateUtils.getWeekStartTime(date));        //当天开始时间
            statMap.put("endTime", DateUtils.getNextWeekStartTime(date));
        }
        else if(groupType.equals("month")){
            statMap.put("groupType", "month");
            statMap.put("startTime", DateUtils.getMonthStartTime(date));        //当周开始时间
            statMap.put("endTime", DateUtils.getNextMonthStartTime(date));
        }
        else if(groupType.equals("year")){
            statMap.put("groupType", "year");
            statMap.put("startTime", DateUtils.getYearStartTime(date));        //当周开始时间
            statMap.put("endTime", DateUtils.getNextYearStartTime(date));
        }
        return  statMap;
    }

    public static String getMonth(Date date) {
        return formatDate(date, "MM");
    }

    public static String getYear(Date date) {
        return formatDate(date, "yyyy");
    }

    /**
     * 某个月第一天时间
     * @return
     */
    public static Date getMonthStartTime(Date date,int i){
        Calendar monthStart = Calendar.getInstance();
        monthStart.setTime(date);
        monthStart.set(Calendar.DAY_OF_MONTH, 1);	//获取本月第一天
        monthStart.set(Calendar.HOUR_OF_DAY, 0);
        monthStart.set(Calendar.MINUTE, 0);
        monthStart.set(Calendar.SECOND, 0);
        monthStart.set(Calendar.MILLISECOND, 0);
        monthStart.add(Calendar.MONTH, i);         //本月第一天减一个月
        nextStartTime = monthStart.getTime();
        return nextStartTime;
    }


    /**
     * 计算两个日期相差天数
     * @return
     */
    public static int daysBetween(Date smdate,Date bdate) throws ParseException
    {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        smdate=sdf.parse(sdf.format(smdate));
        bdate=sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }


    //计算两个天数相差天数
    public static int daysOfTwo(Date fDate, Date oDate) {

        Calendar aCalendar = Calendar.getInstance();

        aCalendar.setTime(fDate);

        int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);

        aCalendar.setTime(oDate);

        int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);

        return Math.abs(day2 - day1);

    }



    /**
     * 判断当前系统时间是否在指定时间范围内
     */
    public static Boolean getDateRange(String beginDate,String endDate){
        Date date=new Date();
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long newDate=date.getTime();
        long begin=0;
        long end=0;
        try {
            c.setTime(sdf.parse(beginDate));
            begin=c.getTimeInMillis();
            c.setTime(sdf.parse(endDate));
            end=c.getTimeInMillis();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(newDate>=begin && newDate<end){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 获取昨日时间 返回格式：yyyyMMdd
     */
    public static Date getLastDay(Date date) {
        Calendar lastDay = Calendar.getInstance();
        lastDay.setTime(date);
        lastDay.add(Calendar.DATE, -1);
        return lastDay.getTime();
    }

    /**
     * 得到指定月的天数
     * */
    public static int getMonthLastDay(Date date)
    {
        Calendar a = Calendar.getInstance();
        a.setTime(date);
        a.set(Calendar.MONTH, a.get(Calendar.MONTH));
        a.set(Calendar.DATE, 1);//把日期设置为当月第一天
        a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 获取当前日期是星期几<br>
     *
     * @param date
     * @return 当前日期是星期几
     */
    public static Integer getWeekOfDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK)-1;
        if (w < 0)
            w = 0;
        return w;
    }

//    public static void main(String[] args) {
//        SimpleDateFormat sdf = new SimpleDateFormat("2017-12-11");
//        Date date = null;
//
//            date = parseDate(sdf.);
//
//        System.out.println(date);
//    }



}
