package net.gichain.genergy.eam.common.util;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Months;
import org.joda.time.Years;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author cjp
 * @date 2020年6月16日
 */
public class DateUtils {
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String DATE_TO_MIN = "yyyy-MM-dd HH:mm";
    public static final String YY_MM_DD = "yy-MM-dd";
    public static final String YYMMDDHHMM = "yyMMddHHmm";
    public static final String YYYYMMDDHHMM = "yyyyMMddHHmm";
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String YYYYMMDDHHMMSSMS = "yyyyMMddHHmmssSSS";
    public static final String YYYYMM = "yyyyMM";


    /**
     * LocalDate转换成Date
     *
     * @param localDate LocalDate日期
     * @return Date日期
     */
    public static Date localDateToDate(LocalDate localDate) {
        if (null == localDate) {
            return null;
        }
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }

    /**
     * Date转换成LocalDate
     *
     * @param date Date日期
     * @return LocalDate日期
     */
    public static LocalDate dateToLocalDate(Date date) {
        if (null == date) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * 将string字符串转化为制定格式的字符串
     *
     * @param dateTimeStr 需要转化的string类型的字符串
     * @param formatStr1  strToDate的转化规则
     * @param formatStr2  dateToStr的转化规则
     * @return
     */
    public static String strToStr(String dateTimeStr, String formatStr1, String formatStr2) {
        return dateToStr(strToDate(dateTimeStr, formatStr1), formatStr2);
    }

    /***
     * 将string字符串转化为Date类型的字符串
     *
     * @param dateTimeStr 需要转化的string类型的字符串
     * @param formatStr   转化规则
     * @return 返回转化后的Date类型的时间
     */
    public static Date strToDate(String dateTimeStr, String formatStr) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(formatStr);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }

    /**
     * 将string字符串转化为Date类型的字符串
     *
     * @param dateTimeStr     需要转化的string类型的字符串
     * @param sourceFormatStr 源转化规则
     * @param targetFormatStr 目标转化规则
     * @return 返回转化后的Date类型的时间
     */
    public static Date strToDate(String dateTimeStr, String sourceFormatStr, String targetFormatStr) {
        Date sourceDate = strToDate(dateTimeStr, sourceFormatStr);
        String targetDateTimeStr = dateToStr(sourceDate, targetFormatStr);
        return strToDate(targetDateTimeStr, targetFormatStr);
    }

    /***
     * 将date类型的时间转化为string类型
     *
     * @param date      需要转化的date类型的时间
     * @param formatStr 转化规则
     * @return 返回转化后的string类型的时间
     */
    public static String dateToStr(Date date, String formatStr) {
        if (date == null) {
            return "";
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(formatStr);
    }

    /**
     * 将localDate类型的时间转化为string类型
     *
     * @param localDate
     * @param formatStr
     * @return
     */
    public static String dateToStr(LocalDate localDate, String formatStr) {
        if (localDate == null) {
            return "";
        }
        DateTime dateTime = new DateTime(localDateToDate(localDate));
        return dateTime.toString(formatStr);
    }

    /***
     * 将string字符串转化为Date类型的字符串
     *
     * @param dateTimeStr 需要转化的string类型的时间
     * @return 返回转化后的Date类型的时间
     */
    public static Date strToDate(String dateTimeStr) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(STANDARD_FORMAT);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }

    /***
     * 将string字符串转化为Date类型的字符串
     *
     * @param dateTimeStr 需要转化的string类型的时间
     * @return 返回转化后的LocalDate类型的时间
     */
    public static LocalDate strToLocalDate(String dateTimeStr) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(STANDARD_FORMAT);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateToLocalDate(dateTime.toDate());
    }

    /**
     * 将string字符串转化为Date类型的字符串, yyyy-MM-dd HH:mm
     *
     * @param dateTimeStr 字符串格式时间  yyyy-MM-dd HH:mm
     * @return
     */
    public static Date depStrToDate(String dateTimeStr) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(DATE_TO_MIN);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }

    /***
     * 将date类型的时间转化为string类型
     *
     * @param date 需要转化的date类型的时间
     * @return 返回转化后的string类型的时间
     */
    public static String dateToStr(Date date) {
        if (date == null) {
            return "";
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(STANDARD_FORMAT);
    }

    /**
     * 当前时间
     *
     * @return
     */
    public static Date now() {
        return DateTime.now().toDate();
    }

    public static LocalDate localNow() {
        return LocalDate.now();
    }

    /**
     * 获取日期在月中是第几天
     *
     * @param date
     * @return
     */
    public static int getDayOfMonth(Date date) {
        DateTime dateTime = new DateTime(date);
        return dateTime.getDayOfMonth();
    }

    /**
     * 获取日期在年中是第几月
     *
     * @param date
     * @return
     */
    public static int getMonthOfYear(Date date) {
        DateTime dateTime = new DateTime(date);
        return dateTime.getMonthOfYear();
    }

    /**
     * @param date
     * @return
     */
    public static int getYear(Date date) {
        DateTime dateTime = new DateTime(date);
        return dateTime.getYear();
    }

    /**
     * 当前时间
     *
     * @param formatStr 时间格式
     * @return
     */
    public static Date now(String formatStr) {
        return strToDate(dateToStr(now(), formatStr), formatStr);
    }

    /**
     * 加n小时
     *
     * @param date 时间
     * @param n    小时数
     * @return
     */
    public static Date plusHours(Date date, int n) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusHours(n).toDate();
    }

    /**
     * 减n小时
     *
     * @param date 时间
     * @param n    小时数
     * @return
     */
    public static Date minusHours(Date date, int n) {
        DateTime dateTime = new DateTime(date);
        return dateTime.minusHours(n).toDate();
    }

    /**
     * 减n月
     *
     * @param date 时间
     * @param n    月数
     * @return
     */
    public static Date minusMonth(Date date, int n) {
        DateTime dateTime = new DateTime(date);
        return dateTime.minusMonths(n).toDate();
    }

    /**
     * 加n天
     *
     * @param date 时间
     * @param days 天数
     * @return
     */
    public static Date plusDays(Date date, int days) {
        return new Date(date.getTime() + days * 24L * 60L * 60L * 1000L);
    }

    /**
     * 加n分钟
     *
     * @param date
     * @param minutes
     * @return
     */
    public static Date plusMinutes(Date date, long minutes) {
        return new Date(date.getTime() + minutes * 60L * 1000L);
    }

    /**
     * 加n秒
     *
     * @param date
     * @param seconds
     * @return
     */
    public static Date plusSeconds(Date date, long seconds) {
        return new Date(date.getTime() + seconds * 1000L);
    }

    /**
     * 相差小时
     *
     * @param startDate
     * @param endDate
     */
    public static Hours intervalHour(Date startDate, Date endDate) {
        DateTime startDateTime = new DateTime(startDate);
        DateTime endDateTime = new DateTime(endDate);
        return Hours.hoursBetween(startDateTime, endDateTime);
    }

    /**
     * 相差天
     *
     * @param startDate
     * @param endDate
     */
    public static Days intervalDay(Date startDate, Date endDate) {
        DateTime startDateTime = new DateTime(startDate);
        DateTime endDateTime = new DateTime(endDate);
        return Days.daysBetween(startDateTime, endDateTime);
    }

    /**
     * 相差月
     *
     * @param startDate
     * @param endDate
     */
    public static Months intervalMonth(Date startDate, Date endDate) {
        DateTime startDateTime = new DateTime(startDate);
        DateTime endDateTime = new DateTime(endDate);
        return Months.monthsBetween(startDateTime, endDateTime);
    }

    /**
     * 相差分钟
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static Minutes intervalMinutes(Date startDate, Date endDate) {
        DateTime startDateTime = new DateTime(startDate);
        DateTime endDateTime = new DateTime(endDate);
        return Minutes.minutesBetween(startDateTime, endDateTime);
    }

    /**
     * 从现在起相差分钟
     *
     * @param endDate 结束时间
     * @return
     */
    public static Minutes intervalMinutesFromNow(Date endDate) {
        DateTime startDateTime = DateTime.now();
        DateTime endDateTime = new DateTime(endDate);
        return Minutes.minutesBetween(startDateTime, endDateTime);
    }

    public static Years intervalYears(Date startDate, Date endDate) {
        DateTime startDateTime = new DateTime(startDate);
        DateTime endDateTime = new DateTime(endDate);
        return Years.yearsBetween(startDateTime, endDateTime);
    }

    /**
     * 获取时间戳
     *
     * @return
     */
    public static long getTimestamp() {
        return DateUtils.now().getTime() / 1000;
    }

    /**
     * 计算星期几
     *
     * @param date
     * @return
     */
    public static String calDayOfWeek(Date date) {
        String result = "";
        DateTime dateTime = new DateTime(date);
        int dayOfWeek = dateTime.getDayOfWeek();
        switch (dayOfWeek) {
            case DateTimeConstants.MONDAY:
                result = "周一";
                break;
            case DateTimeConstants.TUESDAY:
                result = "周二";
                break;
            case DateTimeConstants.WEDNESDAY:
                result = "周三";
                break;
            case DateTimeConstants.THURSDAY:
                result = "周四";
                break;
            case DateTimeConstants.FRIDAY:
                result = "周五";
                break;
            case DateTimeConstants.SATURDAY:
                result = "周六";
                break;
            case DateTimeConstants.SUNDAY:
                result = "周日";
                break;
        }
        return result;
    }

    /**
     * 获取给定天数后日期  yyyy-MM-dd
     *
     * @return
     */
    public static String someDaysLater(int days) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
        calendar.add(Calendar.DATE, days);
        return sdf.format(calendar.getTime());
    }
}

