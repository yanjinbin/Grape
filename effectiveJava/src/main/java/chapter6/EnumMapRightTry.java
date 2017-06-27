package chapter6;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * todo 查看下 enumMap 实现原理  。 effective java  P148
 *
 * @Author Silver bullet
 * @Since 2017/6/27.
 */
public class EnumMapRightTry {
    public static void main(String[] args) {
        Herb[] garden = new Herb[100];


        EnumMap<Herb.Type, Set<Herb>> typeSetEnumMap = new EnumMap<Herb.Type, Set<Herb>>(Herb.Type.class);

        for (Herb.Type t :
                Herb.Type.values()) {
            typeSetEnumMap.put(t, new HashSet<Herb>());
        }

        for (Herb h :
                garden) {
            typeSetEnumMap.get(h.type).add(h);
        }

        System.out.println(typeSetEnumMap);
    }
}
