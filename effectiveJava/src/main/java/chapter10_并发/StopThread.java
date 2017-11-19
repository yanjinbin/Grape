package chapter10_并发;

import java.util.concurrent.TimeUnit;

/**
 * @Author Silver bullet
 * @Since 2017/6/28.
 */
public class StopThread {
    private static boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        // stopRequested = true 无法保证原子操作 所以run 可能 一直运行 并不能保证能顺利stop

//        Thread thread = new Thread(new Runnable() {
//            public void run() {
//                int i = 0;
//                while (!stopRequested) {
//                    i++;
//                    System.out.println("i值\t"+i);j
//                }
//            }
//        });
//
//        thread.start();
//        TimeUnit.SECONDS.sleep(1);
//        stopRequested = true;

        //下面show了如何改进这个方法 用 synchronized 关键字 进行读写同步
        long before = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                if (!getStopReuqested()) {//读操作
                    i++;// 自增也不是原子操作
                }
                System.out.println("i 值\t" + i);
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);//1秒
        setStopRequested(true);//写操作
        long after = System.currentTimeMillis();
        System.out.println("持续时间:\t"+(after-before));

    }

    private static synchronized void setStopRequested(boolean stopRequested) {
        StopThread.stopRequested = stopRequested;
    }

    private static synchronized boolean getStopReuqested() {
        return StopThread.stopRequested;
    }


}
