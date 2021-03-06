package com.yanjinbin.frastructue;

import java.math.BigDecimal;

/**
 *
 * @author xiaobin
 * @since 2018/1/7
 */
public class MathUtil {

    public int toInt(BigDecimal bigDecimal){
        return bigDecimal.intValueExact();
    }

    public long toLong(BigDecimal bigDecimal){
        return bigDecimal.longValueExact();
    }

}
