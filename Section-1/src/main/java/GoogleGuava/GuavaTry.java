package GoogleGuava;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/**
 *  Guava github 地址:https://github.com/google/guava
 *   Guava wiki地址: https://github.com/google/guava/wiki
 *
 * @author Silver & Bullet
 *         since 2016-十二月
 */
public class GuavaTry {
    public static void main(String[] args) {
        list = new ArrayList();
        final Person personA = new Person();
        personA.setAge(1);
        personA.setName("a");
        Person personB = new Person();
        personB.setAge(2);
        personB.setName("b");
        Person personC = new Person();
        personC.setAge(3);
        personC.setName("c");
        list.add(personA);
        list.add(personB);
        list.add(personC);
        //构造map
        //Iterator iterator = list.iterator();
        Maps.uniqueIndex(list,new Function<Person,String>(){

            @Nullable
            public String apply(@Nullable Person input) {
                return personA.getName();
            }
        });
        Multimaps.index(list,new Function<Person,String>(){

            @Nullable
            public String apply(@Nullable Person input) {
                return input.getName();
            }
        });

       // Maps.toMap()

    }
    public  static List list;
}
