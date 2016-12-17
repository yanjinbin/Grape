package GoogleGuava;

import com.google.common.math.DoubleMath;
import com.google.common.math.IntMath;

import java.math.RoundingMode;

/**
 * 首先guava math package 是对apache common MathUtil  补充,而不是替代
 *
 * 另外,需要了解下java 二进制的加减乘除 https://goo.gl/zpiMW1
 *
 * @author Silver & Bullet
 *         on 十二月-16
 */
public class MathTry {
    public static void main(String[] args) {

        System.out.println("subtract  check "+IntMath.checkedSubtract(1344, 234));


        //int i = IntMath.checkedMultiply(Integer.MAX_VALUE, Integer.MIN_VALUE);
        int saturatedAdd = IntMath.saturatedAdd(Integer.MAX_VALUE, Integer.MIN_VALUE);

        System.out.println(saturatedAdd);
        System.out.println(saturatedAdd == Integer.MAX_VALUE);
//主要理解好RoundingMode的几个对余数的取舍
        RoundingMode ceiling = RoundingMode.CEILING;

       // System.out.println("bionimal  result    " + IntMath.binomial(1, 2));

        System.out.println("Pow Operation    " + IntMath.checkedPow(2, 4));

        System.out.println("Factorial result   " + IntMath.factorial(5));

        System.out.println("GCD  result " + IntMath.gcd(234, 60));

        System.out.println("Mod operation " + IntMath.mod(12, 4));

        System.out.println("Prime  is ?    " + IntMath.isPrime(7));

        //2 的 幂  指的是 入参 = 2的n次方
        //  https://zh.wikipedia.org/wiki/2%E7%9A%84%E5%B9%82
        System.out.println("is Power of 2" + IntMath.isPowerOfTwo(234));

        System.out.println("pow result    " + IntMath.pow(3, 4));


        System.out.println("log 2 algorithm result    " + IntMath.log2(9, RoundingMode.DOWN));


        System.out.println("log 10 algorithm result      " + IntMath.log10(101, RoundingMode.CEILING));

        double d1 = 12233444.469;
        System.out.println("DoubleMath round to Int   " + DoubleMath.roundToInt(d1, RoundingMode.CEILING));


        double d2 = 134548689696.35;
        System.out.println("double to Long result   "+DoubleMath.roundToLong(d2, RoundingMode.CEILING));

        double d3 =4.5;

        System.out.println("double to long  by log 2 Arithmetic"+DoubleMath.log2(d3,RoundingMode.CEILING));

        System.out.println("double to long by log 2 Arithmetic RoundingMode down style     "+DoubleMath.log2(d3,RoundingMode.DOWN));

        //MathUtils 实践

     //   RealFieldElement max = MathUtils.max(123, 445);

    }
}
