package JMM;

/**
 * JVM 12/3/3
 *
 * P930 说明了 volatile 使用的时候并不能保证 并发安全
 *
 *
 * “从字节码层面上很容易就分析出并发失败的原因了：当getstatic指令把race的值取到操作栈顶时，volatile关键字保证了race的值在此时是正确的，但是在执行iconst_1、iadd这些指令的时候，其他线程可能已经把race的值加大了，而在操作栈顶的值就变成了过期的数据，所以putstatic指令执行后就可能把较小的race值同步回主内存之中。”

 摘录来自: 周志明. “深入理解Java虚拟机：JVM高级特性与最佳实践[第2版]”。 iBooks.
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
