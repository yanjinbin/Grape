package CommonUtil;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Set;


/**
 * 采用java 8 重新设计引入的java.util.Time package
 * https://goo.gl/OFVz7Z
 * Created by Silver & Bullet
 * since 2016-十二月
 */
public final class CalendarUtil {

    static LocalDateTime localDateTime;

    public static final long DAY_MILL = 24 * 60 * 60 * 1000;

    public static final long HOUR_MILL = 60 * 60 * 1000;

    public static final long MIN_MILL = 60 * 1000;

    public static final long SECOND_MILL = 1000;

    public static final String SHANGHAI_ZONE = "Asia/Shanghai";

    //设置默认时区 上海
//    static {
//        ZoneId shangHaiZone = ZoneId.of(SHANGHAI_ZONE);
//        localDateTime.atZone(shangHaiZone);
//    }

    public static class DateFormat {
        public static final String hyphenSeparate = "yyyy-MM-dd HH:mm:ss";
        public static final String slackSeparate = "yyyy/MM/dd HH:mm:ss";
        public static final String hyphenSeparateDayEnd = "yyyy-MM-dd";
    }

    //convert dateString to localDate
    public static LocalDate parse2LocalDate(String date, String pattern) {

        if (StringUtils.isEmpty(date) || StringUtils.isEmpty(pattern)) {
            return null;
        }

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime localDateTime = LocalDateTime.parse(pattern, dateTimeFormatter);
        return localDateTime.toLocalDate();
    }


    //convert date to localDate
    public static LocalDate convert(Date date) {
        if (date == null) {
            return null;
        }
        return date.toInstant().
                atZone(ZoneId.of(SHANGHAI_ZONE)).
                toLocalDate();
    }

    //convert localDate to date
    public static Date convert(LocalDate localDate) {
        return Date.from(
                localDate.atStartOfDay(ZoneId.of(SHANGHAI_ZONE)).
                        toInstant());
    }

    //convert DateString  to date
    @Deprecated
    public static Date parse2Date(String date, String pattern) {
        LocalDate localDate = parse2LocalDate(date, pattern);
        return convert(localDate);
    }

    //transform means : make a thorough or dramatic change in the form,

    /**
     * @param localDate
     * @param pattern
     * @return dateString with pattern form
     */
    public static String transform(LocalDate localDate, String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        String dateString = localDate.format(dateTimeFormatter);
        return dateString;
    }

    public static String transform(Date date, String pattern) {
        LocalDate localDate = convert(date);
        String dateString = transform(localDate, pattern);
        return dateString;
    }

    //返回2个date之间的时间间隔
    public static final int diff(Date d1, Date d2) {
        long d1Time = d1.getTime();
        long d2Time = d2.getTime();
        return ((int) (d1Time - d2Time / SECOND_MILL));
    }

    //关于ZoneId, LocalDate ,Instant ,LocalDateTime之间的区别  参考链接 https://goo.gl/VzPz4F
    public static final int diff(LocalDate d1, LocalDate d2) {
        long d1Time = d1.atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli();//ZoneOffSet 是不是会有问题 askme
        long d2Time = d2.atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli();
        return ((int) (d1Time - d2Time / 1000));
    }

    //获取当前日期
    public static String getCurrentDate(String pattern){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        String rs = LocalDate.now().format(dateTimeFormatter);
        return rs;
    }


    public static void main(String[] args) {
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        for (String s:availableZoneIds
             ) {

            System.out.println("值     "+s);
        }
    }

}
