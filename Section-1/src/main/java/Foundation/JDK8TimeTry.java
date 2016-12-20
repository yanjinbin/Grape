package Foundation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#patterns
 *
 *https://docs.oracle.com/javase/tutorial/datetime/iso/format.html
 *
 *
 *
 * JDK 8 TimePackage 实践类学习
 * @author Silver & Bullet
 *         on 十二月-19
 */
public class JDK8TimeTry {

    public static void main(String[] args) {
        System.out.println("~~~~~~~JDK8 Time In Action ~~~~~~");
        LocalDate now = LocalDate.now();
        System.out.println("now is     "+now);
        System.out.println("Chronology is    "+now.getChronology());
        System.out.println("day of month is   "+now.getDayOfMonth());
        System.out.println("day of week is    "+now.getDayOfWeek());
        System.out.println("day of year is    "+now.getDayOfYear());
        System.out.println("month value is    "+now.getMonthValue());


        System.out.println("-----------LocalDateTime------------");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime is    "+localDateTime);

        System.out.println("Era is   "+now.getEra());//china east
        System.out.println("Chronology is   "+localDateTime.getChronology());

        System.out.println(localDateTime.getDayOfYear());


        System.out.println("nano is   "+localDateTime.getNano());

        System.out.println("Hour is   "+localDateTime.getHour());
        System.out.println("Second is    "+localDateTime.getSecond());
        System.out.println("Minuste is     "+localDateTime.getMinute());

        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println("-----ZoneID  start -----");
        Iterator<String> iterator = availableZoneIds.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("-------ZoneId end--------------");


        System.out.println("-----Construct with ZoneId----------");

        LocalDateTime tokoyoDateTime = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println(tokoyoDateTime);//create Success

        System.out.println("-------Create DateTime with Time Pattern-----");
        DateTimeFormatter isoDate = DateTimeFormatter.ISO_DATE;
      // keystep
        String input = "2016-12-19 11:11:12";
        LocalDate parse = LocalDate.parse(input, isoDate);
        System.out.println(parse);
        LocalDateTime isolocalDate = LocalDateTime.parse(input, isoDate);
        System.out.println(isolocalDate);

    }
}
