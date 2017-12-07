
/**
 * @Author Silver bullet
 * @Since 2017/6/28.
 */
public class Misc {
    public static void main(String[] args) {
     /*   String string = new String();
        int h = -1233444;
        System.out.println(Integer.toBinaryString(h));
        System.out.println(spread(h));
        System.out.println(Integer.toBinaryString(HASH_BITS));*/
        showBreakOrReturn();
        // todo
        long num= 2147483647*2 ;
        long val = 5 *1024*1024*1024;
        long val1 = 4 *1024*1024*1024L;
        System.out.println(num);
        System.out.println(val);
        System.out.println(val1);

    }
    static final int spread(int h) {
        return (h ^ (h >>> 16)) & HASH_BITS;
    }
    static final int HASH_BITS = 0x7fffffff;

    public static void showBreakOrReturn(){
        int sum = 0;

        for(;;){

           // sum++;
            if(sum >100){
                System.out.println("sum的值"+sum);
                break;
            }
             sum++;
        }
        System.out.println("sum最终的值是"+sum);
    }
}
