import org.junit.Test;

import java.time.LocalDate;

/**
 * @author 吉利不布吉
 * @since 2017/12/30
 */
public class LocalDateTest {
    @Test
    public void localDate(){
        LocalDate now = LocalDate.now();
        System.out.println(now);

        System.out.println(now.minusMonths(12));
        //+1 为什么呢
        System.out.println(now.minusMonths(12).withDayOfMonth(1));
    }
}
