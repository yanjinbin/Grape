package 观察者模式;

/**
 * @author Silver Bullet
 * @since 十二月-20
 */
public class Client {
    public static void main(String[] args) {
        Subject subject = new RealSubject();
        Observer observer1 = new ConcreteObserver();
        Observer observer2 = new ConcreteObserver2();
        subject.addObserver(observer1);
        subject.addObserver(observer2);
        subject.doSomething();
    }
}
