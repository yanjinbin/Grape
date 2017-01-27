package GoogleGuava;

import java.util.*;

/**
 * @author Silver Bullet
 * @since 一月-20
 */

public class MapSort {
    static <String> SortedSet<Map.Entry<String, String>>
    entriesSortedByValues(Map<String, String> map, final Comparator<? super String> comp) {
        SortedSet<Map.Entry<String, String>> sortedEntries = new TreeSet<Map.Entry<String, String>>(
                new Comparator<Map.Entry<String, String>>() {
                    @Override
                    public int compare(Map.Entry<String, String> e1, Map.Entry<String, String> e2) {
                        return comp.compare(e1.getKey(), e2.getKey());
                    }

                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }

    static class Custom {
        final double d;

        Custom(double d) {
            this.d = d;
        }

        @Override
        public String toString() {
            return String.valueOf(d);
        }
    }

    public static void main(String[] args) {
        Map<String, Custom> map = new HashMap<String, Custom>();
        map.put("A", new Custom(1));
        map.put("B", new Custom(4));
        map.put("C", new Custom(2));
        map.put("D", new Custom(3));

//        entriesSortedByValues(map, new Comparator<Custom>() {
//            @Override
//            public int compare(Custom c1, Custom c2) {
//                return Double.compare(c1.d, c2.d);
//            }
//        });
    }
}