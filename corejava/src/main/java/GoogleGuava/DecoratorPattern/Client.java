package GoogleGuava.DecoratorPattern;

/**
 * @author Silver Bullet
 * @since 十二月-20
 */
public class Client {
    public static void main(String[] args) {

        Component concreteComponent = new ConcreteComponent();
        Decorator  decorator = new ConcreteDecorator(concreteComponent);
        decorator.useComponentOperation();

    }
}
