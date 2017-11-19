package GoogleGuava;

import Reflection.Parent;
import lombok.Data;

import java.util.List;

/**
 * @author Silver & Bullet
 *         since 2016-十二月
 */
@Data
public class Person implements Comparable<Person> {
    public Integer age;

    public String name;

    public List<Parent> list;

    @Override
    public int compareTo(Person o) {
        int cmp = age.compareTo(o.getAge());
        if (cmp != 0) {
            return cmp;
        }
        int newCmp = name.compareTo(o.getName());
        return newCmp;
    }

}
