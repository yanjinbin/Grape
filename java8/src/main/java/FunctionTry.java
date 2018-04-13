import com.google.common.base.Function;
import com.google.common.collect.Lists;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * nextodo  研究下 java.util.function 包下的
 * <p>java.util.function.Consumer<T>,
 * java.util.function.Supplier<T>,
 * java.util.function.Predicate<T>,
 * java.util.function.Function<T,R>,
 * </p>
 * <p>
 * https://luyiisme.github.io/2017/01/21/java8-lambda/
 *
 * @Author Grape
 * @Since 2017/8/12.
 */
public class FunctionTry {
    public static void main(String[] args) {

        Lion item = null;

        final List<Lion> list = Lists.newArrayList();
        final Lion lion1 = Lion.builder().age(11).name("aabc").build();
        final Lion lion2 = Lion.builder().age(12).name("ccdd").build();
        list.add(lion1);
        list.add(lion2);
        list.add(item);
        list.stream().map((Function<Lion, Integer>) input -> {
            System.out.println(input.getName());
            return input.getAge();
        }).toArray();

        final ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        integers.stream().map(new Function<Integer, Integer>() {
            @Override
            public Integer apply(@Nullable Integer input) {
                System.out.println(input);
                return input + 1;
            }
        });

    }
}