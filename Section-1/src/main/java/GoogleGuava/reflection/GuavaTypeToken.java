package GoogleGuava.reflection;

import GoogleGuava.Person;
import com.google.common.reflect.TypeToken;

import java.util.List;
import java.util.Map;

/**
 * 看Google Guava之前 ,再温习一遍java 反射 是如何获取泛型信息
 *
 * @author Silver Bullet
 * @since 十二月-17
 */
public class GuavaTypeToken {

    public static void main(String[] args) {
        //google use TypeToken to mainpulate generic type

        //google guava diff to Guice TypeLiteral  is that it  support  non-refined types
        TypeToken<Person> personTypeToken = TypeToken.of(Person.class);

        System.out.println(personTypeToken);


        //obtain raw primitive class
        TypeToken<String> stringTypeToken = TypeToken.of(String.class);
        //wrapper primitive class
        TypeToken<Integer> integerTypeToken = TypeToken.of(int.class);


        //obtain a generci class info as follows

        // constructor empty  anonymous inner class to fetch generic type

        TypeToken<List<String>> typeToken = new TypeToken<List<String>>() {
        };

        TypeToken<Map<?, ?>> mapTypeToken = new TypeToken<Map<?, ?>>() {
        };


//        static <K,V> TypeToken<Map<K,V>> mapToken(TypeToken<K> keyToken,TypeToken<V> valueToken){
//            return new TypeToken<Map<K,V>>(){}.where(new TypeParameter<K>() {
//            },keyToken).where(new TypeParameter<V>() {
//            },valueToken);
//        }






    }
}
