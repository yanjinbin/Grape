package 并发;

import com.google.common.collect.ForwardingSet;

import java.util.Set;

/**
 * @Author Silver bullet
 * @Since 2017/6/28.
 */
public class ObservableSet<E>  extends ForwardingSet<E>{

    protected Set<E> delegate() {
        return null;
    }
}
