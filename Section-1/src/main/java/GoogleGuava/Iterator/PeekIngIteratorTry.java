package GoogleGuava.Iterator;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * 暂时先放弃 这个是高级玩家才能玩的
 * @author Silver Bullet
 * @since 十二月-20
 */
public class PeekIngIteratorTry {
    public static void main(String[] args) {
//        ArrayList<Object> arrayList = Lists.newArrayList();
//        PeekingIterator<Object> peekingIterator = Iterators.peekingIterator(arrayList.iterator());
//        while (peekingIterator.hasNext()){
//            Object next = peekingIterator.next();
//            while (peekingIterator.hasNext()&&peekingIterator.equals(next)){
//                //skip the duplicate element
//                peekingIterator.next();
//            }
//            arrayList.add(next);
//        }

        List<String> arrayList = Lists.newArrayList(Arrays.asList("john","paul","112","john"));
        PeekingIteratorSkipDuplicateValue skipDuplicateValue = new PeekingIteratorSkipDuplicateValue();
       skipDuplicateValue.add("john");
        skipDuplicateValue.add("paul");
        skipDuplicateValue.add("112");
        skipDuplicateValue.add("john");

        Iterator iterator = skipDuplicateValue.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
