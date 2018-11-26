package com.webup.soa.yunshang.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/******************************************
 * @author: 大鹏 (xupenghong@elion.com.cn)
 * @createDate: 2017/8/7
 * @company: (C) Copyright 亿兆华盛 2017
 * @since: JDK 1.8
 * @projectName:IntelliJ IDEA
 * @Description:类功能描述
 ******************************************/
public class DateUtils {

    public static final String YYYYMMDDHHMISS2 = "yyyyMMddHHmmssSS";
    public static final String YYYYMMDDHHMISS = "yyyyMMddHHmmss";
    public static final String START_YYYYMMDD = "yyyy-MM-dd 00:00:00";
    public static final String END_YYYYMMDD = "yyyy-MM-dd 23:59:59";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_FORMAT_PATTERN = "yyyy-MM-dd";

    // 中国时区
    private static final TimeZone zone = TimeZone.getTimeZone("GMT+08:00");
    // 中国国家语言格式
    private static final Locale locale = Locale.CHINESE;

    private static final SimpleDateFormat FORMAT_YYYYMMDDHHMMSS2 = new SimpleDateFormat(YYYYMMDDHHMISS2);
    private static final SimpleDateFormat FORMAT_YYYYMMDDHHMISS = new SimpleDateFormat(YYYYMMDDHHMISS);
    private static final SimpleDateFormat FORMAT_START_YYYYMMDD = new SimpleDateFormat(START_YYYYMMDD);
    private static final SimpleDateFormat FORMAT_END_YYYYMM = new SimpleDateFormat(END_YYYYMMDD);
    private static final SimpleDateFormat FORMAT_YYYY_MM_DD_HH_MM_SS = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);


    public static String formatCurrentDate(String pattern) {
        if (pattern == null || pattern.trim().equals("")) {
            pattern = DEFAULT_FORMAT_PATTERN;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(currentDate());
    }
    public static Date currentDate() {
        return new Date();
    }

    public static synchronized String currentTimestamp() {
        Calendar calendar = Calendar.getInstance(zone, locale);
        Calendar.getInstance(zone, locale);
        Date time = calendar.getTime();
        String format = FORMAT_YYYYMMDDHHMMSS2.format(time);
        return format;
    }

    public static synchronized String currentTimestamp0() {
        Calendar calendar = Calendar.getInstance(zone, locale);
        Calendar.getInstance(zone, locale);
        Date time = calendar.getTime();
        String format = FORMAT_YYYYMMDDHHMISS.format(time);
        return format;
    }

    public static Date getCurrentDate() {
        Calendar calendar = Calendar.getInstance(zone, locale);
        Calendar.getInstance(zone, locale);
        return calendar.getTime();
    }

    public static Date getDayOfStartTime(String date) throws Exception {
        Timestamp timestamp = Timestamp.valueOf(date + " 00:00:00");
        return Timestamp.valueOf(FORMAT_START_YYYYMMDD.format(timestamp));
    }

    public static Date getDayOfEndTime(String date) throws Exception {
        Timestamp timestamp = Timestamp.valueOf(date + " 23:59:59");
        return Timestamp.valueOf(FORMAT_END_YYYYMM.format(timestamp));
    }

    public static String dateFormat(Date date, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    public static Date parseDate(String date, String format) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.parse(date);
    }

    public static String toDateString(Date date) {
        return FORMAT_YYYY_MM_DD_HH_MM_SS.format(date);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(currentTimestamp());
        Date date = getDayOfEndTime("2017-08-30");
        System.out.println(toDateString(date));

        System.out.println(dateFormat(new Date(), "yyyy-MM-dd HH:mm:ss"));

        System.out.println(toDateString(new Date()));
    }

}
