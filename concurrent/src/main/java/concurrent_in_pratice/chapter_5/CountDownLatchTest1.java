package concurrent_in_pratice.chapter_5;

import java.util.concurrent.CountDownLatch;

/**
 * https://www.cnblogs.com/skywang12345/p/3533887.html
 */

public class CountDownLatchTest1 {

    private static int LATCH_SIZE = 5;

    private static CountDownLatch doneSignal;

    public static void main(String[] args) {

        try {
            doneSignal = new CountDownLatch(LATCH_SIZE);
            // 新建5个任务
            for (int i = 0; i < LATCH_SIZE; i++) {
                new InnerThread().start();
            }

            System.out.println("main await begin.");
            // "主线程"等待线程池中5个任务的完成
            doneSignal.await();

            System.out.println("main await finished.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class InnerThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " sleep 1000ms.\t" +System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 将CountDownLatch的数值减1
                doneSignal.countDown();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("继续");
            }
        }
    }
}