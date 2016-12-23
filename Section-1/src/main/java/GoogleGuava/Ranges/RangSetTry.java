package GoogleGuava.Ranges;

import com.google.common.collect.*;

import java.util.Set;

/**
 *
 * at first ,Range  must be contiguous . so if you must create a discrete range ,you can use DiscreteDomain
 * as follows
 * https://goo.gl/y79JTm
 *
 * @author Silver & Bullet
 *         on 十二月-20
 */
public class RangSetTry {

    public static void main(String[] args) {
        RangeSet<Integer> treeRangeSet = TreeRangeSet.create();
        treeRangeSet.add(Range.closed(1,10));
        treeRangeSet.add(Range.open(13,19));
        Set<Range<Integer>> rangeSet = treeRangeSet.asRanges();
        for (Range item:rangeSet
             ) {
            System.out.println("Range的范围     "+item.toString());
        }
        System.out.println("-----------我是长长的分割线 Range Try----------");
        treeRangeSet.add(Range.closed(15,28));
        rangeSet = treeRangeSet.asRanges();
        for (Range item:rangeSet){
            System.out.println("Range的范围     "+item.toString());
        }

        System.out.println("-----------我是长长的分割线- intersect judge ---------");


        boolean intersects = treeRangeSet.intersects(Range.closed(13, 22));
        System.out.println("intersects is right ?     "+intersects);

        System.out.println("Contain 29   "+treeRangeSet.contains(29));
        System.out.println("is Empty   "+treeRangeSet.isEmpty());
        Range<Integer> integerRange = Range.downTo(7, BoundType.CLOSED);
        treeRangeSet.add(integerRange);

        System.out.println("-----------我是长长的分割线----------");
        rangeSet = treeRangeSet.asRanges();
        for (Range item:rangeSet){
            System.out.println("Range的范围     "+item.toString());
        }

        //取包含range的 最小子集
        Range<Integer> x = treeRangeSet.rangeContaining(9);


        System.out.println("range contain 9 operation    "+x);
        System.out.println("-----------我是长长的分割线弄出个sub 是从parent集合 取得意思----------");

        RangeSet<Integer> subRangeSet = treeRangeSet.subRangeSet(Range.closedOpen(12, 50));
        Set<Range<Integer>> ranges = subRangeSet.asRanges();

        for (Range<Integer> range : ranges) {
            System.out.println("Range的范围是多少来着哟    ?        "+range.toString());
        }


        System.out.println("-----------我是长长的分割线 atleast----------");

        Range<Integer> atleastRange = Range.atLeast(-1);

        Range<Integer> atMostRange = Range.atMost(10);


        treeRangeSet.add(atleastRange);
        treeRangeSet.add(atMostRange);

        System.out.println("-----------我是长长的分割线add Atleast ---------");
        rangeSet = treeRangeSet.asRanges();
        for (Range item:rangeSet
                ) {
            System.out.println(item.toString());
        }

        System.out.println("-----------我是长长的分割线----------");


        //is connected   reflexive and symmetric   but not transitive

        boolean isConnected = Range.closed(3, 6).isConnected(Range.open(7, 10));
        System.out.println(Range.closed(3,6));
        System.out.println(Range.open(7,10));
        System.out.println("is connected ?    "+ isConnected);


        boolean isConnected1 = Range.closed(3, 6).isConnected(Range.open(6, 10));
        System.out.println(Range.closed(3,6));
        System.out.println(Range.open(6,10));
        System.out.println("is connected ?    "+ isConnected1);


        //Range intersection(return the maximal range enclosed ) 和  span(return the minimal range )

        //最大交集
        Range<Integer> intersection = Range.closed(3, 20).intersection(Range.closed(9, 29));
        System.out.println("intersection is     "+intersection);


        //throw IllegalArgumentException

       // Range<Integer> intersection1 = Range.open(3, 5).intersection(Range.open(5, 10));


        //span in action
        //returns the minimal range that encloses both this range and other. If the ranges are both connected, this is their union.

        Range<Integer> spanRange = Range.closed(3, 5).span(Range.open(7, 10));
        System.out.println(spanRange);

        //discrete domain
        System.out.println("---------discrete domain ------------");
        Integer integer = DiscreteDomain.integers().maxValue();
        System.out.println(integer);

        long distance = DiscreteDomain.longs().distance(11L, 23L);
        System.out.println(distance);

        //https://goo.gl/XLiAOV   https://goo.gl/v0g70u

        //see sample https://goo.gl/y79JTm

        //ContiguousSet.create(integerRange,)


        Range<Integer> range8 = Range.closed(5, 15);

        System.out.println("------- discrete domain  in action ---------");
        printRange(range8);


        ImmutableSortedSet<Integer> set = ContiguousSet.create(Range.open(1, 5), DiscreteDomain.integers());
// set contains [2, 3, 4]

        ContiguousSet.create(Range.greaterThan(0), DiscreteDomain.integers());
// set contains [1, 2, ..., Integer.MAX_VALUE]
    }

    //discrete domain
    private static void printRange(Range<Integer> range) {

        System.out.print("[ ");

        for(int grade : ContiguousSet.create(range, DiscreteDomain.integers())) {
            System.out.print(grade +" ");
        }

        System.out.println("]");
    }
}
