package JMM;

/**
 * JVM 12/3/3
 *
 * @Author Silver bullet
 * @Since 2017/7/2.
 */
public class VolatileTest {

    private static volatile int race = 0;

    public static void increase() {
        race++;//非原子操作，volatile 并不能保证并发的安全性，因为 race  需要读取旧值+1 (也就是说依赖于当前变量)
    }

    public static final int THREADS_COUNT = 7;

    public static void main(String[] args) {
        Thread[] threadGroup = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threadGroup[i] = new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        increase();
                    }
                }
            });
            threadGroup[i].start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println("race 值是：\t\t" + race);
    }

}
