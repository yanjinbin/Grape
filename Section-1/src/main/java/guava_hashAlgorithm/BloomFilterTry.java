package guava_hashAlgorithm;

import CommonUtil.Alphabet;
import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;

import java.util.Random;

/**
 * http://www.sigma.me/2011/09/13/hash-and-bloom-filter.html
 * <p>
 * http://billmill.org/bloomfilter-tutorial/
 * <p>
 * wiki for bloom filter https://en.wikipedia.org/wiki/Bloom_filter
 * <p>
 * 简而言之 : 布鲁姆过滤器是一种概率数据结构,能帮你判断某个对象是否 一定不在过滤器中 或者 可能添加到过滤器中
 *
 * @Author Silver bullet
 * @Since 2017/5/16.
 */
public class BloomFilterTry {
    public static void main(String[] args) {
        Funnel<Person> personFunnel = new Funnel<Person>() {
            @Override
            public void funnel(Person from, PrimitiveSink into) {
                into.putInt(from.getId()).putInt(from.getBirthYear()).putString(from.getFirstName(), Charsets.UTF_8).putString(from.getLastName(), Charsets.UTF_8);

            }
        };

        BloomFilter<Person> friendsFilter = BloomFilter.create(personFunnel, 5000, 0.01);
        Person p1 = Person.builder().id(1).birthYear(1990).lastName("Yan").firstName("Jinbin").build();

        friendsFilter.put(p1);


        int i = 0;
        while (i < 500) {
            i++;
            int j = new Random(10).nextInt(27);
            String c = Character.toString(Alphabet.LOWERCASE.toChar(j));
            String b = Character.toString(Alphabet.UPPERCASE.toChar(j));

            Person m = Person.builder().id(i).birthYear(new Random(2000).nextInt()).firstName(c).lastName(b).build();

            friendsFilter.put(m);
        }

        Person p2 = Person.builder().id(10000).lastName("嘿嘿").firstName("嘻嘻").birthYear(19901116).build();
        System.out.println(friendsFilter.mightContain(p1));
        // 利用 bloomfilter 我们可以实现异步加载 合理规划资源
//        简而言之，布鲁姆过滤器是一种概率数据结构，它允许你检测某个对象是一定不在过滤器中，还是可能已经添加到过滤器了

        System.out.println(friendsFilter.mightContain(p2));


    }
}
