package concurrent_in_pratice.chapter_5.HashMapImprove;

import lombok.Builder;

import java.util.Map;

/**
 * 高效并行缓存实现
 *
 * @Author Grape
 * @Since 2017/7/5.
 */
@Builder
public class Memoizer<K, V> implements ExpensiveCompute<K, V> {

    private final Map<K, Future<V>> cache = new ConcurrentHashMap<K, Future<V>>();

    private final ExpensiveCompute<K, V> c;


    @Override
    public V compute(final K k) throws InterruptedException {
        while (true) {
            Future<V> future = cache.get(k);
            if (future == null) {
                Callable<V> eval = new Callable<V>() {
                    @Override
                    public V call() throws Exception {
                        return c.compute(k);
                    }
                };

                FutureTask<V> ft = new FutureTask<V>(eval);
                future = cache.putIfAbsent(k, ft);

                if (future == null) {
                    future = ft;
                    ft.run();
                }

                try {
                    return ft.get();
                } catch (ExecutionException e) {
                    //
                    e.printStackTrace();
                }

            }
        }
    }
}
