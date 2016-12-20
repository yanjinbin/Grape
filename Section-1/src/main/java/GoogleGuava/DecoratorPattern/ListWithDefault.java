package GoogleGuava.DecoratorPattern;

import com.google.common.collect.ForwardingIterator;
import com.google.common.collect.ForwardingList;

import java.util.Iterator;
import java.util.List;

/**
 * @author Silver Bullet
 * @since 十二月-20
 */
public class ListWithDefault<E> extends ForwardingList<E> {
    final  E defaultValue;

    final  List<E> delegate;

    protected ListWithDefault(E defaultValue, List<E> delegate) {
        this.defaultValue = defaultValue;
        this.delegate = delegate;
    }
    //must implement
    @Override
    protected List<E> delegate() {
        return delegate;
    }

    @Override
    public E get(int index) {
        E v = super.get(index);
        return  (v==null?defaultValue:v);
    }

    @Override
    public Iterator<E> iterator() {
        final  Iterator<E> iter = super.iterator();
        return  new ForwardingIterator<E>() {
            @Override
            protected Iterator<E> delegate() {
                return  iter;
            }

            @Override
            public E next() {
                E v = super.next();
                return (v==null?defaultValue:v);
            }
        };
    }
}
