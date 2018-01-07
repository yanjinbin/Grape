package GoogleGuava.order;

import CommonUtil.CalendarUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author 吉利不布吉
 * @since 2018/1/3
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimeDuration implements Comparable {

    private GroupType groupType;

    private LocalDateTime fromTime;

    private LocalDateTime toTime;

    @Override
    public String toString() {
        if (groupType == GroupType.DAY) {
            return CalendarUtil.transform(fromTime, "yyyy-MM-dd");
        }
        if (groupType == GroupType.WEEK) {
            return CalendarUtil.transform(fromTime, "yyyy-MM-dd") + "~" + CalendarUtil.transform(toTime, "yyyy-MM-dd");
        }
        if (groupType == GroupType.MONTH) {
            return CalendarUtil.transform(fromTime, "yyyy-MM");
        }
        return "Undefined";
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof TimeDuration) {
            TimeDuration cmp = (TimeDuration) o;
            return this.getFromTime().compareTo(cmp.getFromTime());
        } else {
            throw new ClassCastException("the compared element is not a Class of TimeDuration,please check it");
        }
    }


}
