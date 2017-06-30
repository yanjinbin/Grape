package com.yanjinbin.concurrent.chapter_2;

import org.springframework.web.servlet.HttpServletBean;

import javax.annotation.concurrent.NotThreadSafe;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author Silver bullet
 * @Since 2017/6/30.
 */
@NotThreadSafe
public class UnsafeCachingFactorizer extends HttpServletBean {


    private final AtomicReference<BigInteger> lastNumber = new AtomicReference<BigInteger>();

    private final AtomicReference<BigInteger[]> lastFactors = new AtomicReference<BigInteger[]>();


    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        BigInteger i = extractFromRequest(req);
        if (i.equals(lastNumber.get())) {
            encodeIntoResponse(res, lastFactors.get());
        } else {
            BigInteger[] factor = factor(i);
            lastNumber.set(i);// 尽管使用了院子应用 但是无法确保 2次更新 是同步的 ，也就无法保证竞态条件（也就是说 factor 的乘积 应该就是 lastNumber 的值）
            lastFactors.set(factor);
            encodeIntoResponse(res, factor);
        }
    }


    void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
    }

    BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("7");
    }

    BigInteger[] factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger[]{i};
    }
}
