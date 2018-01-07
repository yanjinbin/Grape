package CommonUtil;

import org.apache.commons.lang3.StringUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Set;
import java.util.TimeZone;


/**
 * http://www.importnew.com/15637.html
 * <p>
 * http://www.importnew.com/14140.html
 * <p>
 * 采用java 8 重新设计引入的java.util.Time package
 * https://goo.gl/OFVz7Z
 * Created by Silver & Bullet
 * since 2016-十二月
 */
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

    public static void main(String[] args) {

        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
        System.out.println(LocalDateTime.now().toLocalDate());

        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        for (String s : availableZoneIds
                ) {

            System.out.println("值     " + s);
        }
        ZoneId zoneId = TimeZone.getDefault().toZoneId();
        System.out.println(zoneId);


        String currentDate = getCurrentDate(DateFormat.hyphenSeparateDayEnd, ZoneId.of(SHANGHAI_ZONE));
        System.out.println(currentDate);
        System.out.println("-------------------分割线---------------");
        LocalDate parse = LocalDate.parse("2007-12-01 10:15:30", DateTimeFormatter.ofPattern(DateFormat.hyphenSeparate));
        System.out.println(parse);
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.getHour());
        System.out.println(now.getChronology());
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getMinute());
        System.out.println(now.getMonthValue());
        System.out.println(now.getDayOfWeek());
        System.out.println(now.getDayOfYear());
        System.out.println(now.getSecond());

        System.out.println("======");

        Date date = new Date();
        LocalDateTime start = CalendarUtil.toLocalDateTime(date);
        System.out.println(start);
        System.out.println(start.plusDays(1));
        System.out.println(start);

    }


}
