package GoogleGuava.DecoratorPattern;

/**
 * 被 装饰者
 * @author Silver Bullet
 * @since 十二月-20
 */
public class Decorator {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    public Decorator() {
    }

    public  void useComponentOperation(){
        this.component.operation();
    }
}
