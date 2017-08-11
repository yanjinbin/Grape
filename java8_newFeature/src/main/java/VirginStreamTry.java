import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * https://www.ibm.com/developerworks/cn/java/j-lo-java8streamapi/
 *
 * @Author Grape
 * @Since 2017/8/10.
 */
public class VirginStreamTry {
    public static void main(String[] args) {
        Stream<Integer> source = Stream.of(1, 2, 3, 4, 5, 6);
        List<String> list = Lists.newArrayList("a", "c", "bd", "wioeujds", "qoweope");
        Stream<List<String>> listStream = Stream.of(list);
        int[] ints = {1, 23, 34, 4, 56, 67, 78, 3, 4};

        IntStream stream = Arrays.stream(ints);
        boolean b = stream.allMatch(x -> x > 4);
        IntStream intStream = stream.filter(x -> x > 43);//流操作

        int[] array = intStream.toArray();
        String[] wordList = {"12", "a", "nd", "cdee", "wwee"};

        Stream<String> wordStream = Stream.of(wordList);

        List<String> filterString = wordStream.map(String::toUpperCase).collect(Collectors.toList());

        List<Integer> collect = source.map(n -> n * 3).filter(n -> n % 2 == 0).collect(Collectors.toList());//注意下 Collectors 不是 Collections

    }

    public void runTask() {
        new Thread(new Runnable() {
            public void run() {
                System.out.println("running a task");
            }
        }).start();
    }

    public void runThreadUseLambda() {
        new Thread(() -> {
            System.out.println("running a task by lambda way");
        }).start();
    }

    public void sortLambda() {
        List<Integer> list = new ArrayList<Integer>();
        Collections.sort(list, (x, y) -> {
            return y - x;
        });
    }

//    class Animal<Integer> implements Comparator{
//
//
//        @Override
//        public int compare(Object o1, Object o2) {
//            return 0;
//        }
//    }
}
