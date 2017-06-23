package chapter2;

import lombok.Builder;

/**
 * 利用 builder 风格 来解决 构造器多参数问题，避免 P9的丑陋写法
 *
 * @Author Silver bullet
 * @Since 2017/6/23.
 */
@Builder
public class Person {

    public String name;

    public int age;

    public long height;


    // 避免创建不必要的对象

//    private final Date birthDate;
//
//    private static final Date BOOM_START;
//
//    private static final Date BOOM_END;
//
//    static {
//        Calendar gmt = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
//        gmt.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
//        BOOM_START = gmt.getTime();
//        gmt.set(1964, Calendar.APRIL, 1, 0, 0, 0);
//        BOOM_END = gmt.getTime();
//    }
//
//    public boolean isBabyBoomer() {
//        return birthDate.compareTo(BOOM_START) > 0
//                && birthDate.compareTo(BOOM_END) < 0;
//    }
}
