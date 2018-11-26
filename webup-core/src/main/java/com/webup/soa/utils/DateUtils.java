package com.webup.soa.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.webup.soa.exception.BusinessException;

/**
 *
 * @Title: DateUtils.java
 * @Description:(日期处理工具类)
 * @date 2015-2-2 上午9:10:51
 * @version V1.0
 */
public class DateUtils {
    static final Log logger = LogFactory.getLog(DateUtils.class);

    public static String DEFAULT_FORMAT_PATTERN = "yyyy-MM-dd";
    public static final String FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String CODE = "YYYYMMDDHHMISS";
    public static final String SIGN_TIME = "yyyyMMddHHmmss";
    public static final String ZM_TIME = "yyyyMMddHHmm";

    public static Date currentDate() {
        return new java.util.Date();
    }

    public static String formatDate(Date date,String pattern) {
        if (ValidatorUtil.isNull(pattern)){
            pattern = DEFAULT_FORMAT_PATTERN;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }

    public static String formatCurrentDate(String pattern) {
        if (ValidatorUtil.isNull(pattern)){
            pattern = DEFAULT_FORMAT_PATTERN;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(currentDate());
    }

    public static Date formatCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_FORMAT_PATTERN);
        String dateStr = dateFormat.format(currentDate());
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Date formatCurDate(String attachment) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT);
        String dateStr = formatCurrentDate(DEFAULT_FORMAT_PATTERN+attachment);
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getSignTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(SIGN_TIME);
        return dateFormat.format(currentDate());
    }

    public static String getFormatCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT);
        return dateFormat.format(currentDate());
    }

    public static String getZmTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(ZM_TIME);
        return dateFormat.format(currentDate());
    }

    /**
     * 两个时间之间相关的分钟数
     *
     * @param startDateStr
     *            起始时间
     * @param endDateStr
     *            结束时间
     * @return
     */
    public static long getSignTimeMinuteInterval(String startDateStr, String endDateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(SIGN_TIME);
        try {
            Date start = dateFormat.parse(startDateStr);
            Date end = dateFormat.parse(endDateStr);
            return minPeriod(start, end);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void main(String[] args) {
//		String d1=formatCurrentDate(DEFAULT_FORMAT_PATTERN+" 00:00:00");
//		System.out.println(d1);
//		String d2=formatCurrentDate(DEFAULT_FORMAT_PATTERN+" 23:59:59");
//		System.out.println(d2);
        // String signTime = getSignTime();
        // System.out.println(signTime);
        // String dateStrForAddMinute = getDateStrForAddMinute(1, null);
        // System.out.println(dateStrForAddMinute);
        // long signTimeInterval = getSignTimeMinuteInterval("20170830224013",
        // dateStrForAddMinute);
        // System.out.println(signTimeInterval);
        // System.out.println(signTimeInterval==5);
        // System.out.println(formatCurrentDate("yyyy-MM-dd HH:mm:ss"));

        Date start = Timestamp.valueOf("2018-03-01 00:00:00");
        Date end = Timestamp.valueOf("2018-03-31 23:59:59");


        System.out.println(datePeriod(start, end));

    }

    /**
     * 日期相差多少天
     *
     * @param start start
     * @param end end
     * @return long
     */
    public static long datePeriod(Date start, Date end) {
        Date startDay = day(start);
        Date endDay = day(end);
        if (startDay == null || endDay == null) {
            return -1;
        }
        return Math.abs((startDay.getTime() - endDay.getTime()) / (1000L * 60L * 60L * 24L));
    }

    /**
     * 返回天
     *
     * @param date date
     * @return Date
     */
    public static Date day(Date date) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(dateFormat.format(date));
        } catch (ParseException e) {
            logger.error("DateUtils day() parse failed", e);
            throw new BusinessException("日期格式转换异常", null, false, false);
        }
    }

    /**
     * 计算日期后多少天
     *
     * @param date date
     * @param days days
     * @return Date
     */
    public static Date after(Date date, int days) {
        Calendar temCalendar = initCalendar(date);
        temCalendar.add(Calendar.DAY_OF_YEAR, days);
        return temCalendar.getTime();
    }

    /**
     * 计算周第几天,如果在date前,向前推进
     *
     * @param date date
     * @param dayOfWeek dayOfWeek
     * @return Date
     */
    public static Date dayOfWeek(Date date, int dayOfWeek, boolean isForward) {
        Calendar temCalendar = initCalendar(date);
        temCalendar.set(Calendar.DAY_OF_WEEK, dayOfWeek);
        if (isForward && temCalendar.getTime().before(date)) {
            temCalendar.add(Calendar.DAY_OF_WEEK, 7);
        }
        return temCalendar.getTime();
    }

    public static Date dayOfPreviousWeek(Date date, int dayOfWeek) {
        Calendar temCalendar = initCalendar(date);
        temCalendar.add(Calendar.DAY_OF_WEEK, -7);
        return dayOfWeek(temCalendar.getTime(), dayOfWeek, false);
    }

    /**
     * 计算月底
     *
     * @param date date
     * @return Date
     */
    public static Date endOfMonth(Date date) {
        Calendar temCalendar = initCalendar(date);
        temCalendar.set(Calendar.DAY_OF_MONTH, temCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return temCalendar.getTime();
    }

    /**
     * 计算月第几天
     *
     * @param date date
     * @param dayOfMonth dayOfMonth
     * @return Date
     */
    public static Date dayOfMonth(Date date, int dayOfMonth, boolean isForward) {
        Calendar temCalendar = initCalendar(date);
        int maxDayOfMonth = temCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int minDayOfMonth = temCalendar.getActualMinimum(Calendar.DAY_OF_MONTH);
        if (dayOfMonth > maxDayOfMonth) {
            dayOfMonth = maxDayOfMonth;
        } else if (dayOfMonth < minDayOfMonth) {
            dayOfMonth = minDayOfMonth;
        }
        temCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        if (isForward && temCalendar.getTime().before(date)) {
            temCalendar.set(Calendar.DAY_OF_MONTH, maxDayOfMonth);
            temCalendar.add(Calendar.DAY_OF_MONTH, dayOfMonth);
        }

        return temCalendar.getTime();
    }

    public static Date dayOfPreviousMonth(Date date, int dayOfMonth) {
        Calendar temCalendar = initCalendar(date);
        temCalendar.add(Calendar.MONTH, -1);
        return dayOfMonth(temCalendar.getTime(), dayOfMonth, false);
    }

    private static Calendar initCalendar(Date date) {
        Calendar temCalendar = Calendar.getInstance();
        temCalendar.setTime(date);
        return temCalendar;
    }

    /**
     * 当前时间加？分钟后的时间String
     *
     * @param minute minute
     * @return String
     */
    public static String getDateStrForAddMinute(int minute) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MINUTE, minute);
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);
        return sdf.format(now.getTimeInMillis());
    }

    /**
     * 当前时间加？分钟后的时间String
     *
     * @param minute
     * @param dateFormat
     * @return String
     */
    public static String getDateStrForAddMinute(int minute, String dateFormat) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MINUTE, minute);
        if (ValidatorUtil.isNull(dateFormat)){
            dateFormat = SIGN_TIME;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(now.getTimeInMillis());
    }

    /**
     * 将日期格式的字符串转换为长整型
     *
     * @param date
     * @return long
     */
    public static long dateStrToLong(String date) throws ParseException {
        if (ValidatorUtil.isNotNull(date)) {
            SimpleDateFormat sf = new SimpleDateFormat(FORMAT);
            return sf.parse(date).getTime();
        }
        return 0L;
    }

    public static Date stringToDate(String str, String DateFormat) {
        SimpleDateFormat format = new SimpleDateFormat(DateFormat);
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
        }
        return date;
    }

    public static int getYear() {
        Calendar now = Calendar.getInstance();
        return now.get(Calendar.YEAR);
    }

    public static int getMonth() {
        Calendar now = Calendar.getInstance();
        return now.get(Calendar.MONTH) + 1;
    }

    public static int getDay() {
        Calendar now = Calendar.getInstance();
        return now.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 日期相差多少分钟
     *
     * @param start
     * @param end
     * @return long
     */
    public static long minPeriod(Date start, Date end) {
        if (start == null || end == null) {
            return -1;
        }
        return Math.abs((start.getTime() - end.getTime()) / (1000L * 60L));
    }

    public static Date parseDate(String date, String format) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.parse(date);
    }

}
