package 观察者模式;

/**
 * @author Silver Bullet
 * @since 十二月-20
 */
public class RealSubject extends Subject {
    @Override
    public void doSomething() {
        System.out.println("我在打劫哟");
        this.notifyObserver();
    }
}
