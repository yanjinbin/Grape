package chapter6;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Silver bullet
 * @Since 2017/6/27.
 */
public class EnumMapTry {
    public static void main(String[] args) {
        Herb[] garden = new Herb[100];

        Set<Herb>[] herbsByType = (Set<Herb>[]) new HashSet[Herb.Type.values().length];

        for (int i = 0; i < herbsByType.length; i++) {
            herbsByType[i] = new HashSet<Herb>();
        }


        for (Herb herb :
                garden) {
            herbsByType[herb.type.ordinal()].add(herb);
        }
        for (int i = 0; i < herbsByType.length; i++) {
            System.out.printf("%s: \t%s \t%n", Herb.Type.values()[i], herbsByType[i]);
        }


    }
}
