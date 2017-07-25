
/**
 * @Author Silver bullet
 * @Since 2017/6/28.
 */
public class Misc {
    public static void main(String[] args) {
        String string = new String();
        int h = -1233444;
        System.out.println(Integer.toBinaryString(h));
        System.out.println(spread(h));
        System.out.println(Integer.toBinaryString(HASH_BITS));
    }
    static final int spread(int h) {
        return (h ^ (h >>> 16)) & HASH_BITS;
    }
    static final int HASH_BITS = 0x7fffffff;
}
