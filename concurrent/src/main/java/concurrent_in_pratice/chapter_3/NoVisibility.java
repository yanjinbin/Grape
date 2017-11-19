package concurrent_in_pratice.chapter_3;

/**
 * @Author Silver bullet
 * @Since 2017/6/30.
 */
public class NoVisibility {

    private static boolean ready;

    private static int number;

    public static void main(String[] args) {
        new ReaderThread().start();
        // 指令重排序
        number = 42;
        ready = true;
    }

    public static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println("number：\t" + number);
        }
    }

}
