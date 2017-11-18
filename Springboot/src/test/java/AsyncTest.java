/*
import com.yanjinbin.springboot.Async.MultiTask;

import java.util.com.yanjinbin.concurrent.Future;

*/
/**
 * @author Silver & Bullet
 *         on 三月-04
 *//*

public class AsyncTest extends BaseTest{

    public void asyncTest() throws InterruptedException {
        long start=System.currentTimeMillis();
        MultiTask task = new MultiTask();
        Future<String> taskOne = task.doTaskOne();
        Future<String> taskTwo = task.doTaskTwo();
        Future<String> taskThree = task.doTaskThree();
        while(true) {
            if(taskOne.isDone() && taskTwo.isDone() && taskThree.isDone()) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(1000);
        }
        long end = System.currentTimeMillis();
        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");

    }
}
*/
