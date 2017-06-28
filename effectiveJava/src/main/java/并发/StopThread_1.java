package 并发;

import java.util.concurrent.TimeUnit;

/**
 * @Author Silver bullet
 * @Since 2017/6/28.
 */
public class StopThread_1 {
    private volatile static boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        long before = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while (!stopRequested) {
                    i++;
                    System.out.println("i值\t"+i);
                }
            }
        });

        thread.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;//主内存可见
        long after = System.currentTimeMillis();
        System.out.println("after-before\t"+(after-before));
    }

}
