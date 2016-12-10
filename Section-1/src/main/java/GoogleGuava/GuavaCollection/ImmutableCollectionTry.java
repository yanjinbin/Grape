package GoogleGuava.GuavaCollection;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by yanjinbin on 16-12-11.
 */
public class ImmutableCollectionTry {
    public static void main(String[] args) {
        ImmutableSet<? extends Serializable> immutableSet = ImmutableSet.of(1, 2, 3, 4, 'a', "a", new String("ok"));

        ImmutableList<? extends Serializable> immutableList = immutableSet.asList();


        Set treeSet = new TreeSet();
        treeSet.add("a");
        treeSet.add("b");
        treeSet.add('c');
        ImmutableSet copyOf = ImmutableSet.copyOf(treeSet);
        ImmutableSet.Builder<Object> builderSet = ImmutableSet.builder().add(treeSet).add(immutableSet);


    }
}
