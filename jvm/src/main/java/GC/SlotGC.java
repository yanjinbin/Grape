package GC;

/**
 *
 * @Author Silver bullet
 * @Since 2017/6/22.
 */
public class SlotGC {
    public static void main(String[] args) {
        byte[] holder = new byte[32 * 1024 * 1024];
        System.gc();// 没有作用的 holder 还是引用了 32mb的数组空间


    }
}
