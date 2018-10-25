package GoogleGuava;

import CallBack.Student;
import Reflection.Family;
import Reflection.Parent;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 函数式编程风格
 *
 * @author Silver & Bullet
 * on 十二月-25
 */
public class FunctionTry {
    public static void main(String[] args) {
        Function function = new Function<Student, String>() {

            @Nullable
            @Override
            public String apply(@Nullable Student input) {
                return input.getName();
            }
        };


        Function<Person, String> compose = Functions.compose(new Function<Parent, String>() {
            @Nullable
            @Override
            public String apply(@Nullable Parent input) {
                return input.getParentname();
            }
        }, new Function<Person, Parent>() {
            @Nullable
            @Override
            public Parent apply(@Nullable Person input) {
                return input.getList().get(0);
            }
        });

        Function<Object, Integer> heightFunction = Functions.constant(HEIGHT);

        Function<Object, Object> objectFunction = Functions.identity();

        Map<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("a", 1);
        hashMap.put("b", 2);
        hashMap.put("c", 3);

        Function<String, Integer> forMapFunction = Functions.forMap(hashMap);


        //
        Predicate<Object> predicate = Predicates.instanceOf(Person.class);

        Predicate<Object> nullPredictes = Predicates.isNull();


        Predicate<Class<?>> classPredicate = Predicates.subtypeOf(Family.class);
        Predicate<Parent> parentPredicate = Predicates.equalTo(new Parent(1, 2));

        List<Integer> list = new ArrayList<Integer>(5);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Predicate<Integer> integerPredicate = Predicates.in(list);


        Predicate<Object> alwaysFalse = Predicates.alwaysFalse();
        //combine two predicate
        Predicate<Object> composePredicate = Predicates.and(nullPredictes, alwaysFalse);

        Predicate<CharSequence> aPredicate = Predicates.containsPattern("a");

        Predicate<CharSequence> pattetnPredicate = Predicates.contains(Pattern.compile("a*a"));


        // Predicates.or((Predicate<Integer>) input -> input>=0).or();


    }

    public static final int HEIGHT = 10;
}
