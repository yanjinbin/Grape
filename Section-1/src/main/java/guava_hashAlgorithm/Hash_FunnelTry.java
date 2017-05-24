package guava_hashAlgorithm;

import com.google.common.base.Charsets;
import com.google.common.hash.*;

/**
 * hash funnel hash 求值
 *
 * @Author Silver bullet
 * @Since 2017/5/16.
 */
public class Hash_FunnelTry {
    public static void main(String[] args) {


        Funnel<Person> personFunnel = new Funnel<Person>() {
            @Override
            public void funnel(Person from, PrimitiveSink into) {
                into.putInt(from.getId()).putInt(from.getBirthYear()).putString(from.getFirstName(), Charsets.UTF_8).putString(from.getLastName(), Charsets.UTF_8);

            }
        };

        HashFunction hashFunction = Hashing.md5();
        Hasher hasher = hashFunction.newHasher();

        Person person = Person.builder().id(1).birthYear(1990).firstName("jinbin").lastName("yan").build();


        HashCode hash = hasher.putBoolean(true).putInt(2).putLong(32L).putObject(person, personFunnel).hash();
        System.out.println(hash.asInt());


        // todo 一致性哈希算法使用举例
        // https://goo.gl/h8WsyX
//        https://zh.wikipedia.org/wiki/%E4%B8%80%E8%87%B4%E5%93%88%E5%B8%8C
    }
}


