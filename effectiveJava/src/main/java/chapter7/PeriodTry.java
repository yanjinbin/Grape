package chapter7;

import java.util.Date;

/**
 * @Author Silver bullet
 * @Since 2017/6/27.
 */
public class PeriodTry {
    public static void main(String[] args) {
        Date start = new Date();
        Date end = new Date();
        Period period = new Period(start, end);
        end.setYear(78);
        //这样类就可变了
    }
}
