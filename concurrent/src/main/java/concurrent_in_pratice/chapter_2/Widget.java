package concurrent_in_pratice.chapter_2;

/**
 * @Author Silver bullet
 * @Since 2017/7/3.
 */
public class Widget {
    public synchronized void doSomething() {
        System.out.println("widget is doing");
    }
}
