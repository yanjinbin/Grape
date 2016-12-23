package GoogleGuava;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;

import java.util.Set;

/**
 * @author Silver & Bullet
 *         on 十二月-20
 */
public class RangSetTry {
    public static void main(String[] args) {
        RangeSet<Integer> treeRangeSet = TreeRangeSet.create();
        treeRangeSet.add(Range.closed(1,10));
        treeRangeSet.add(Range.open(11,19));
        Set<Range<Integer>> rangeSet = treeRangeSet.asRanges();
        for (Range item:rangeSet
             ) {
            System.out.println(item.toString());
        }

        treeRangeSet.add(Range.closed(15,28));
        boolean intersects = treeRangeSet.intersects(Range.closed(13, 22));
        System.out.println("intersects is right ?     "+intersects);

        Range<Integer> atleastRange = Range.atLeast(-1);
        Range<Integer> atMostRange = Range.atMost(10);

        treeRangeSet.add(atleastRange);
        treeRangeSet.add(atMostRange);

        for (Range item:rangeSet
                ) {
            System.out.println(item.toString());
        }

    }
}
