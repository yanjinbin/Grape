package chapter7;

import lombok.Data;

import java.util.Date;

/**
 * @Author Silver bullet
 * @Since 2017/6/27.
 */
@Data
public class Period {

    private final Date start;

    private final Date end;

    public Period(Date start, Date end) {

        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if (this.start.compareTo(this.end) > 0) {
            throw new IllegalArgumentException("end < start");
        }

        // 下面的可以造成对象不安全 内在逻辑缺陷

//        if (start.compareTo(end)>0){
//            throw  new IllegalArgumentException("end < start \t wrong ");
//        }
//        this.start = start;
//        this.end = end;
    }
}
