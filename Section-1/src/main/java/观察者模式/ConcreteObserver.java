package 观察者模式;

/**
 * @author Silver Bullet
 * @since 十二月-20
 */
public class ConcreteObserver implements Observer {
    @Override
    public void update() {
        System.out.println("观察者1正在观察 subject realSubject");
    }
}
