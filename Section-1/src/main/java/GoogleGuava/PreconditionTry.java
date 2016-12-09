package GoogleGuava;

import com.google.common.base.Preconditions;

/**
 * @author Silver & Bullet
 *         since 2016-十二月
 */
public class PreconditionTry {
    public static void main(String[] args) {
        try {

           // Preconditions.checkElementIndex(1, 2); ENSURE IN RANGE FOR ARRAY LIST SET data structure

            // Preconditions.checkState() 类似 checkArgument方法 只不过抛出的异常不同而已
            Preconditions.checkArgument(PreconditionTry.i > j, "expected i > j ,but %s < %s ", PreconditionTry.i, j);
            Preconditions.checkArgument(j == 4, "Argument was %s but expected 4 ", j);


            String s = Preconditions.checkNotNull(PreconditionTry.s);
        } catch (Exception e) {
            //  e.printStackTrace();
            System.out.println("name    " + e.getClass().getName());
            System.out.println("message    " + e.getMessage());
        }


    }

    public static String getString(String s) {
        return s;
    }

    public static int i = 2;

    public static int j = 3;

    public static int getInt(int i) {
        return i;
    }

    public static String s = null;
}
