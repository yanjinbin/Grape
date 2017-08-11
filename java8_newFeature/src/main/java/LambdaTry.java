import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * https://luyiisme.github.io/2017/01/21/java8-lambda/
 *
 * @Author Grape
 * @Since 2017/8/11.
 */
public class LambdaTry {
    public static void main(String[] args) {
        List<Integer> integers = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);

        for (Integer i : integers) {
            System.out.println(i);
        }
        // x 前面的 integer 可加可不加
        integers.forEach((Integer x) -> System.out.println(x));


        integers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer x) {
                System.out.println("x 的值" + x);
            }
        });

        Lion l1 = Lion.builder().age(11).name("汤纬民").build();
        Lion l2 = Lion.builder().age(12).name("张雅娇").build();

        ArrayList<Lion> lions = Lists.newArrayList(l1, l2);
        lions.forEach(Lion::accept);

        Consumer<Animal> animalConsumer = animal -> {
            System.out.println("我是 animal 你是谁?");
        };


        int var = 1000;

        integers.forEach(x -> {
            // var++;  看下报错
            System.out.println(x + var);
        });

//        this 引用 在 lambda 表达式中行不通

        integers.forEach(x -> {
            //System.out.println(this.toString());
        });

        integers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(this.toString());
            }
        });

        new LambdaTry().doSth();
        // integer to string
        integers.forEach(x -> {

            // old style
            //System.out.println(String.valueOf(x));

            Function<Integer, String> i2s = String::valueOf;
            System.out.println(i2s.apply(x));

            //应用一个构造函数

            //        System.out.println(new Integer("11"));

            Function<String,Integer> s2i=Integer::new;
            System.out.println(s2i.apply("11"));

        });




    }

    public void doSth() {
        List<Integer> integers = Arrays.asList(2, 4, 6, 8);
        integers.forEach(x -> {
            //这里允许使用 this 应用
            System.out.println(this.toString());
            System.out.println(x);
        });

    }
}
