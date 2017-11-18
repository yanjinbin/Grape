package concurrent_in_pratice.chapter_1;

import javax.annotation.concurrent.NotThreadSafe;

/**
 * @Author Silver bullet
 * @Since 2017/6/29.
 */
@NotThreadSafe
public class UnsafeSequence {
    private int value;

    private int getNext() {
        return value++; // 复合操作
    }

    //线程安全
//    private synchronized int getNext(){
//        return value++;
//    }
}
