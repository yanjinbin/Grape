package chapter5;

/**
 * @Author Silver bullet
 * @Since 2017/6/27.
 */
public class GenericTry {
    public static void main(String[] args) {

        // 列表优先于数组

        Object[] longs = new Long[1];
        longs[0]="i will throw ArrayStoreException";

       // List<Object> objectList = new ArrayList<Long>();  // 编译时候 就会出现类型匹配

        // 静态工具类 优先考虑使用方新方法 p113




    }
}
