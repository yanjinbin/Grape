/**
 * http://www.infoq.com/cn/articles/java-interrupt-mechanism
 * http://wiki.jikexueyuan.com/project/java-concurrency/thread-interrupt.html
 * http://www.cnblogs.com/onlywujun/p/3565082.html
 * @Author Silver bullet
 * @Since 2017/7/1.
 */
public class ThreadInterruptTry {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().interrupted());
        Thread.currentThread().interrupt();
        System.out.println(Thread.currentThread().isAlive());
        System.out.println(Thread.currentThread().interrupted());
        System.out.println(Thread.currentThread().isInterrupted());
    }
}
