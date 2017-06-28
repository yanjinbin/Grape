package chapter8;

import java.util.Random;

/**
 * P187
 * <p>
 *
 *  每个程序员 应该速度 java.util  java.lang java.io  package 下的类源码
 *
 * 伪随机数产生 ： 伪随机数生成器  数论和2的求补算法
 * nextodo 看下伪随机数的产生
 * @Author Silver bullet
 * @Since 2017/6/28.
 */
public class PseudoRandom {
    public static void main(String[] args) {
        int n = (Integer.MAX_VALUE / 3) * 2;
        int low = 0;
        for (int i = 0; i < 1000000; i++) {
            if (random(n)<n/2) {
                low++;
            }
        }

        System.out.println(low);

    }

    private final static Random rnd = new Random(
    );

    static int random(int n) {
        return Math.abs(rnd.nextInt()) % n;
    }

}
