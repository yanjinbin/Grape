package springboot;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * @author Silver & Bullet
 *         on 三月-04
 */
@Component
public class MultiTask {
    public static Random random =new Random();
    @Async
    public Future<String> doTaskOne() throws InterruptedException {
        System.out.println("任务1执行开始");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end = System.currentTimeMillis();
        System.out.println("耗时:  "+(end-start));
        System.out.println("任务1执行结束");
        return new AsyncResult<>("任务1执行结束");
    }

    @Async
    public Future<String> doTaskTwo() throws InterruptedException {
        System.out.println("任务2执行开始");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end = System.currentTimeMillis();
        System.out.println("耗时:  "+(end-start));
        System.out.println("任务2执行结束");
        return new AsyncResult<>("任务2执行结束");
    }
    @Async
    public Future<String> doTaskThree() throws InterruptedException {
        System.out.println("任务3执行开始");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end = System.currentTimeMillis();
        System.out.println("耗时:  "+(end-start));
        System.out.println("任务3执行结束");
        return new AsyncResult<>("任务3执行结束");
    }

}
