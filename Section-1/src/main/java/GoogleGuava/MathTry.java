package GoogleGuava;

import com.google.common.math.IntMath;

import java.math.RoundingMode;

/**
 * @author Silver & Bullet
 *         on 十二月-16
 */
public class MathTry {
    public static void main(String[] args) {

        //int i = IntMath.checkedMultiply(Integer.MAX_VALUE, Integer.MIN_VALUE);
        int saturatedAdd = IntMath.saturatedAdd(Integer.MAX_VALUE, Integer.MIN_VALUE);

        System.out.println(saturatedAdd);
        System.out.println(saturatedAdd==Integer.MAX_VALUE);
//主要理解好RoundingMode对余数的
        RoundingMode ceiling = RoundingMode.CEILING;

    }
}
