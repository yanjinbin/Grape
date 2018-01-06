package GoogleGuava.order;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author 吉利不布吉
 * @since 2018/1/5
 */
public class OrderTry {
    public static void main(String[] args) {
        TimeDuration t1 = TimeDuration.builder()
                .fromTime(LocalDateTime.of(2017, 11, 11, 0, 0))
                .toTime(LocalDateTime.of(2017,12,23,13,0))
                .groupType(GroupType.DAY)
                .build();

        TimeDuration t2 = TimeDuration.builder()
                .fromTime(LocalDateTime.of(2018, 2, 11, 0, 0))
                .toTime(LocalDateTime.of(2017, 12, 22, 0, 0))
                .groupType(GroupType.DAY)
                .build();

        TimeDuration t3 = TimeDuration.builder()
                .fromTime(LocalDateTime.of(2017,12,11,0,0))
                .toTime(LocalDateTime.of(2017,12,24,0,0))
                .groupType(GroupType.DAY)
                .build();

        List<TimeDuration> durations = Lists.newArrayList(t1, t3,t2);

        Ordering<TimeDuration> o1 = Ordering.from(new Comparator<TimeDuration>() {
            @Override
            public int compare(TimeDuration o1, TimeDuration o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("====");
        System.out.println(Ordering.natural().isStrictlyOrdered(Lists.newArrayList(11, 13, 22)));
        System.out.println(Ordering.natural().isOrdered(durations));

        show(durations,o1);

    }

    public static void  show(List list, Comparator comparator){
        System.out.println("是否有序 ? \t\t");
        System.out.println("===排序前=====");
        System.out.println(list);
        System.out.println("====j     son序列化====");
        System.out.println(JSON.toJSONString(list,true));
        System.out.println("====排序后====");
        Collections.sort(list,comparator);
        System.out.println(list);
        System.out.println("===json 序列化====");
        System.out.println(JSON.toJSONString(list,true));
    }

}
