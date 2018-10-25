import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 流的几个高级操作
 * flatMap  reduce 生成自己的流
 *
 * @Author Grape
 * @Since 2017/8/11.
 */
public class SeniorStreamTry {
    public static void main(String[] args) {

        Runnable r = () -> System.out.println("hello world");
        Consumer<Integer> c = (x) ->  System.out.println(x);

        BiConsumer<Integer, String> b = (x,  y) -> System.out.println(x + " : " + y);

        Predicate<String> p = (String s) -> s == null;

        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        Stream<Integer> outputStream = inputStream.
                flatMap((childList) -> childList.stream());//flatmap用法
        final List<Integer> collect = outputStream.collect(Collectors.toList());
        System.out.printf(collect.toString());



        Stream.of("A", "B", "C", "D", "E", "F").reduce("拼接\t\t", String::concat);


        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);

        int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);

        int sumValue_1 = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);

        String concat = Stream.of("a", "B", "c", "D", "e", "F").
                filter(x -> x.compareTo("Z") > 0).
                reduce("", String::concat);


        int[] ints = {1, 3, 4, 5, 66, 77, 8, 82, 34, 2344, 66, 78, 8, 99, 3, 34, 56, 67, 8, 89900, 2323445};

        IntStream intStream = Arrays.stream(ints);
        // int 数组操作

        intStream.skip(3).limit(10).forEach(x -> System.out.println("x 的值\t" + x));

        // inputStream.sorted().forEach(x -> System.out.println("排序后的值\t" + x));  // nextodo 报错 需要自己看下

        // 进阶 自己生成流
        Random seed = new Random();

        Supplier<Integer> random = seed::nextInt;
        Stream.generate(random).limit(10).forEach(System.out::println);


        // 自定义 supplier

        // iterator

        // groupby

    }
}
