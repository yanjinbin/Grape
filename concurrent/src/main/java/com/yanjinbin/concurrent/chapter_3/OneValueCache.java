package com.yanjinbin.concurrent.chapter_3;


import javax.annotation.concurrent.Immutable;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * @Author Silver bullet
 * @Since 2017/6/30.
 */
@Immutable
public class OneValueCache {
    private final BigInteger lastNumber;
    private final BigInteger[] lastFactors;


    // Arrays.copyOf() 什么用

    public OneValueCache(BigInteger i, BigInteger[] factors) {
        lastFactors = Arrays.copyOf(factors, factors.length);
        lastNumber = i;
    }

    public BigInteger[] getFactors(BigInteger i) {
        if (lastNumber == null || !lastNumber.equals(i)) {
            return null;
        } else return Arrays.copyOf(lastFactors, lastFactors.length);
    }
}
