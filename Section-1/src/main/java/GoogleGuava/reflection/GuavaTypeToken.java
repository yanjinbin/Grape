package GoogleGuava.reflection;

import GoogleGuava.Person;
import com.google.common.reflect.TypeToken;

/**
 *
 *  看Google Guava之前 ,再温习一遍java 反射 是如何获取泛型信息
 * @author Silver Bullet
 * @since 十二月-17
 */
public class GuavaTypeToken {
    public static void main(String[] args) {
        //google use TypeToken to mainpulate generic type

        //google guava diff to Guice TypeLiteral  is that it  support  non-refined types
        TypeToken<Person> personTypeToken = TypeToken.of(Person.class);

        System.out.println(personTypeToken);
    }
}
