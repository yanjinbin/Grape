package GoogleGuava;

import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import com.google.common.hash.PrimitiveSink;

/**
 *
 * java内置的 object hash code 没有考虑好,或者说支持减少碰撞性
 * @author Silver & Bullet
 *         on 十二月-17
 */
public class HashTry {
    public static void main(String[] args) {

        HashFunction hashFunction = Hashing.md5();
        Hasher hasher = hashFunction.newHasher();
        hasher.putInt(1).putObject(new Person(), new Funnel<Person>() {
            public void funnel(Person from, PrimitiveSink into) {
                ;
            }
        });


        HashCode hash = hasher.hash();
        byte[] bytes = hash.asBytes();


        //Bloom Filter



    }
}
