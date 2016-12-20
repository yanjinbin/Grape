package 观察者模式;

/**
 * @author Silver Bullet
 * @since 十二月-20
 */
public class ConcreteObserver2 implements Observer {
    @Override
    public void update() {
        System.out.println("观察者2正在观察");
    }
}
