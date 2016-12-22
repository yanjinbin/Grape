package GoogleGuava.Iterator;

import com.google.common.collect.Iterators;
import com.google.common.collect.PeekingIterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Silver Bullet
 * @since 十二月-20
 */
public class PeekingIteratorSkipDuplicateValue extends ArrayList{
    @Override
    public Iterator iterator() {
        PeekingIterator peekingIterator = Iterators.peekingIterator(super.iterator());
        while (peekingIterator.hasNext()){
            Object next = peekingIterator.next();
            while(peekingIterator.hasNext()&&peekingIterator.peek().equals(next)){
                peekingIterator.next();
            }
            add(next);
        }
        return peekingIterator;
    }
}
