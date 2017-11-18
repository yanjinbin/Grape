package concurrent_in_pratice;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author Grape
 * @Since 2017/7/5.
 */
public class ConcurrentHashMapTry {
    private static final Map<String, Student> map = new ConcurrentHashMap<String, Student>();

    public static void main(String[] args) {
        Student s1 = Student.builder().id(1).name("习近平").age(11).build();
        Student s2 = Student.builder().id(2).name("王岐山").age(12).build();
        Student s3 = Student.builder().id(3).name("江泽民").age(13).build();

        map.put(s1.getName(), s1);
        map.put(s2.getName(), s3);
        map.put(s3.getName(), s3);
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
