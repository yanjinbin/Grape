package GoogleGuava;

import com.google.common.base.Charsets;
import com.google.common.hash.*;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 单项散列函数
 * <p>
 * 哈希碰撞
 * <p>
 * java内置的 object hash code 没有考虑好,或者说支持减少碰撞性
 * <p>
 * http://wiki.jikexueyuan.com/project/google-guava-official-tutorial/hash.html
 *
 * @author Silver & Bullet
 *         on 十二月-17
 */
public class HashTry {
    public static void main(String[] args) {

        HashFunction hashFunction = Hashing.md5();

        synchronizedTest("你个2b");


        Hasher hasher = hashFunction.newHasher();

        hasher.putInt(1).putObject(new Person(), new Funnel<Person>() {
            @Override
            public void funnel(Person from, PrimitiveSink into) {
            }
        });


        HashCode hash = hasher.hash();
        byte[] bytes = hash.asBytes();
        //需要注意的是  putString().putString()  insensive to order . cause  unintended hash collisions
        Funnel<Person> personFunnel = new Funnel<Person>() {
            @Override
            public void funnel(Person from, PrimitiveSink into) {
                into.putString(from.getName(), Charsets.UTF_8).
                        putInt(from.getAge()).
                        putBoolean(true);
            }
        };


        //Bloom Filter   基本原理是第一次,元素加入集合时, 通过K个散列函数 将这个元素散列成 一个数组中的K个点,同时这些位点只能有2个取值( 1 , 0 ) ,K次散列完毕,将他们同时置为1,

        //当再次加入的时候 ,  通过相同的bloom filter  (也就是同样的K个散列函数)  去判断K个位点是否为1 ,如果都是1  ,很可能存在,如果有任何一个0  则一定不存在

        // probabilistic data structure   算法复杂度为O(K)
        // http://llimllib.github.io/bloomfilter-tutorial/
        // https://en.wikipedia.org/wiki/Bloom_filter


        // bloom Filter 过滤器 实战


        BloomFilter<Person> friends = BloomFilter.create(personFunnel, 500, 0.01);
        List<Person> persons = new ArrayList<Person>();
        for (Person friend : persons) {
            friends.put(friend);
        }


        // some time later
//        Person jackson = new Person();
//        if (friends.mightContain(jackson)) {
//            //the probability that dude reached this place f he isn't a friend is 1%
//            // we might ,for example ,start asynchronously loading things for dude ,while we do a more expansive exact check
//
//            //很好的运用 概率去 做异步的操作 , 用 概率去换取时间空间
//        }

        HashFunction murmurHash = Hashing.murmur3_32(10);

        Hasher mumurHash = murmurHash.newHasher();

        // 如果object已经有了实现

        // Hashing.combineOrdered(persons.iterator())


        //一致性哈希算法  在分布式中的运用    https://en.wikipedia.org/wiki/Consistent_hashing
        int consistentHash = Hashing.consistentHash(persons.hashCode(), 10);

        System.out.println("consistent Hash  is    " + consistentHash);

    }

    public static  synchronized void synchronizedTest(String s) {
        if (!StringUtils.isBlank(s)) {
            System.out.println(s + "你大爷的你输错了啊 ~~~~");
        }
    }


}
