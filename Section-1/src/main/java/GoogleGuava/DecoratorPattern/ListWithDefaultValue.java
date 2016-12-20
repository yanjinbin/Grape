package GoogleGuava.DecoratorPattern;

import com.google.common.collect.ForwardingIterator;
import com.google.common.collect.ForwardingList;

import java.util.Iterator;
import java.util.List;

/**
 *
 * Guava 装饰者 模式  这是建立在你对JDK Collection 相当熟悉的情况下,知道JDK的优缺点,和了解装饰者模式的情况下,才能对JDK Collection 集合框架 做出符合业务需求的改动
 * @author Silver Bullet
 * @since 十二月-20
 */
public class ListWithDefaultValue<E> extends ForwardingList<E> {
    final E defaultValue;

    final List<E> delegate;

    protected ListWithDefaultValue(E defaultValue, List<E> delegate) {
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
        //return super.get(index);  不然的话,会和逾期不一致
        E v = super.get(index);
        return (v == null ? defaultValue : v);
    }

    @Override
    public Iterator<E> iterator() {
        final Iterator<E> iter = super.iterator();
        return new ForwardingIterator<E>() {
            @Override
            protected Iterator<E> delegate() {
                return iter;
            }

            @Override
            public E next() {
                E v = super.next();
                return (v == null ? defaultValue : v);
            }
        };
    }
}
