package concurrent_in_pratice.chapter_5;

import java.util.concurrent.CountDownLatch;

/**
 * 闭锁 CountingDownLatch  一次性对象
 * http://www.importnew.com/15731.html
 *
 * @Author Grape
 * @Since 2017/7/4.
 */
public class TestHarness {
    public static void main(String[] args) throws InterruptedException {
        int num = 0;
        int threads_count = 10;
        Thread task = new Thread(new Runnable() {
            int n = 0;

            @Override
            public void run() {
                n++;
            }
        });

        System.out.println(timeTasks(threads_count, task));

    }

    public static long timeTasks(int threads_count, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(threads_count);
        for (int i = 0; i < threads_count; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        startGate.await();
                        try {
                            task.run();
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            System.out.println(endGate.getCount());
                            endGate.countDown();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();

        }

        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end - start;

    }
}
