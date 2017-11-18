package GoogleGuava.DecoratorPattern;

import java.util.Arrays;
import java.util.List;

/**
 * @author Silver Bullet
 * @since 十二月-20
 */
public class GuavaDecoratorClient {
    public static void main(String[] args) {
        List<String> names = new ListWithDefaultValue<String>("unknown",Arrays.asList("Alice",null,"John","Bob","Carol",null));
        System.out.println("index 1 is "+names.get(1));
        for (String name :
                names) {
            System.out.println(name);
        }
    }
}
