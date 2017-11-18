package concurrent_in_pratice.chapter_3;

import org.springframework.web.servlet.HttpServletBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;

/**
 * @Author Silver bullet
 * @Since 2017/6/30.
 */
public class VolatileCachedFactorizer extends HttpServletBean {

    private volatile OneValueCache cache = new OneValueCache(null, null);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.service(req, resp);
        BigInteger i = extractFromReq(req);
        BigInteger[] factors = cache.getFactors(i);
        if (factors == null) {
            factors = factor(i);
            cache = new OneValueCache(i, factors);
        }
        encodeIntoResponse(resp, factors);


    }

    private void encodeIntoResponse(HttpServletResponse resp, BigInteger[] factors) {
        System.out.println("encode into response");
    }

    private BigInteger[] factor(BigInteger i) {
        return new BigInteger[0];
    }

    private BigInteger extractFromReq(HttpServletRequest req) {
        return null;
    }
}
