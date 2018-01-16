package com.yanjinbin.frastructue;


import org.springframework.util.StringUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public final class CalendarUtil {

    static LocalDateTime localDateTime = LocalDateTime.now();

    public static final long DAY_MILL = 24 * 60 * 60 * 1000;

    public static final long HOUR_MILL = 60 * 60 * 1000;

    public static final long MIN_MILL = 60 * 1000;

    public static final long SECOND_MILL = 1000;

    public static final String SHANGHAI_ZONE = "Asia/Shanghai";


    public static final ZoneId DEFAULT_ZONE = ZoneId.of(SHANGHAI_ZONE);


    public static class DateFormat {
        public static final String hyphenSeparate = "yyyy-MM-dd HH:mm:ss";
        public static final String slackSeparate = "yyyy/MM/dd HH:mm:ss";
        public static final String hyphenSeparateDayEnd = "yyyy-MM-dd";
    }

    public static LocalDate parse2LocalDate(String date, String pattern) {

        if (StringUtils.isEmpty(date) || StringUtils.isEmpty(pattern)) {
            return null;
        }

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate localDate = LocalDate.parse(pattern, dateTimeFormatter);
        return localDate;
    }

    public static LocalDateTime parse2LocalDateTime(String date, String pattern) {

        if (StringUtils.isEmpty(date) || StringUtils.isEmpty(pattern)) {
            return null;
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime parse = LocalDateTime.parse(date, dateTimeFormatter);
        return parse;
    }


    public static String transform(LocalDate localDate, String pattern) {
        if (localDate == null) {
            return null;
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        String dateString = localDate.format(dateTimeFormatter);
        return dateString;
    }

    public static String transform(LocalDateTime localDateTime, String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        String format = localDateTime.format(dateTimeFormatter);
        return format;
    }

    //返回2个date之间的时间间隔
    public static final int diff(Date d1, Date d2) {
        long d1Time = d1.getTime();
        long d2Time = d2.getTime();
        return ((int) (d1Time - d2Time / SECOND_MILL));
    }


    public static final int diff(LocalDateTime d1, LocalDateTime d2) {
        long d1Time = d1.toInstant(ZoneOffset.UTC).toEpochMilli();//ZoneOffSet 是不是会有问题 askme
        long d2Time = d2.toInstant(ZoneOffset.UTC).toEpochMilli();
        return ((int) (d1Time - d2Time / 1000));
    }

    public static String getCurrentDate(String pattern, ZoneId zoneId) {
        LocalDate now = null;
        if (zoneId != null) {
            now = LocalDate.now(ZoneId.of(SHANGHAI_ZONE));
        } else {
            now = LocalDate.now();
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        String rs = now.format(dateTimeFormatter);
        return rs;
    }


    public static LocalDate toLocalDate(Date date) {
        Instant instant = date.toInstant();
        LocalDate localDate = instant.atZone(DEFAULT_ZONE).toLocalDate();
        return localDate;
    }


    public static Date toDate(LocalDate localDate) {
        Date from = Date.from(localDate.atStartOfDay(DEFAULT_ZONE).toInstant());
        return from;
    }


    public static LocalDateTime toLocalDateTime(Date date) {
        LocalDateTime localDateTime = date.toInstant().atZone(DEFAULT_ZONE).toLocalDateTime();
        return localDateTime;
    }


    public static Date toDate(LocalDateTime localDateTime) {
        Date from = Date.from(localDateTime.atZone(DEFAULT_ZONE).toInstant());
        return from;

    }


}
