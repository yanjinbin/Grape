package codeTrick;

/**
 * @author Silver & Bullet
 *         on 三月-15
 */
public class TrickTry {
    public static void main(String[] args) {
        //持久代 OOM
        String s="who";
        System.out.println("who"==s);
        System.out.println("who"=="who");
        System.out.println("who"==new String("who"));
        System.out.println("who"==new String("who").intern());
        //finally
        System.out.println(getResult());

    }

    static int value = 0;
    static int inc() {return value++;} static int dec() {return value--;} static int getResult() {
        try {
           // throw new RuntimeException("haha");
            return inc();
        } finally {
            return dec();
        }
    }
}
