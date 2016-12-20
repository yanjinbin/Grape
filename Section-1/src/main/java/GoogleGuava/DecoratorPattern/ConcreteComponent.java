package GoogleGuava.DecoratorPattern;

/**
 *  装饰元素实现方
 * @author Silver Bullet
 * @since 十二月-20
 */
public class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("添加元素---- 正在装饰中~~~么么哒");
    }
}
