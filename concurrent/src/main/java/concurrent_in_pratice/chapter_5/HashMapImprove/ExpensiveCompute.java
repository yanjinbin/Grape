package concurrent_in_pratice.chapter_5.HashMapImprove;

/**
 * @Author Grape
 * @Since 2017/7/5.
 */
public interface ExpensiveCompute<K, V> {
    public V compute(final K k) throws InterruptedException;
}
