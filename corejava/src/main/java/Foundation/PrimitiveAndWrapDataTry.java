package Foundation;

import java.util.Objects;

/**
 * @author Silver Bullet
 * @since 十二月-30
 */
public class PrimitiveAndWrapDataTry {
    public static void main(String[] args) {
        Integer i = -1;
        Integer j = -1;
        System.out.println("i==j"+(Objects.equals(i, j)));
        System.out.println();
        Integer a = 129;
        Integer b = 129;
        System.out.println("Integer compare a==b   "+(Objects.equals(a, b)));
        System.out.println("Integer Compare a.equals(b)   "+(a.equals(b)));

        int m = -1;
        int n = -1;
        System.out.println("int compare nullString==n  "+(m==n));
        int q=-129111;
        int r =-129111;
        System.out.println("int compare q==r   "+(q==r));
        
    }
}
