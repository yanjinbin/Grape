package concurrent_in_pratice.chapter_3;

/**
 * @Author Silver bullet
 * @Since 2017/6/30.
 */
public class CountingSheep {
    // 展示了 volatile 使用前置条件 和 实用 场景
    volatile boolean asleep;// 类似于加了读写锁

    void trySleep() {
        while (!asleep) {
            countSheep();
        }
    }

    private void countSheep() {
        System.out.println("\t counting sheep \t");
    }
}
