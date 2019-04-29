
import com.yanjinbin.concurrent.GuavaConcurrency.LRUCache;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LRUCacheTest {
    private static final Logger log = LoggerFactory.getLogger(LRUCacheTest.class);
    private static LRUCache<String, Integer> cache = new LRUCache<>(10);

    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            cache.put("k" + i, i);
        }
        for (int i = 0; i < 10; i++) {
        //    String key = "k" + RandomUtil.getNum(0, 9);
        }
        log.info("all cache :'{}'", cache);
        cache.put("k" + 10, 10);
        log.info("After running the LRU algorithm cache :'{}'", cache);
    }
}
