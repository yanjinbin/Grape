package GoogleGuava.DecoratorPattern;

/**
 * ConcreteDecorator 装饰 Decorator
 * @author Silver Bullet
 * @since 十二月-20
 */
public class ConcreteDecorator extends Decorator {
    private Decorator decorator;

    public ConcreteDecorator(Component component, Decorator decorator) {
        super(component);
        this.decorator = decorator;
    }

    public ConcreteDecorator(Decorator decorator) {
        this.decorator = decorator;
    }

    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void useComponentOperation() {
        addBehaviour();
        super.useComponentOperation();
    }

    private void addBehaviour(){
        System.out.println("--------行为添加ing-------");
    }
}
