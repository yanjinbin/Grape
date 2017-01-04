package RedisUtil;

import lombok.Getter;

import java.io.Serializable;

/**
 * Created by luobin.lzb on 15-5-25.
 */
public class RedisResult<Value> implements Serializable {
    private static final long serialVersionUID = 6006894164531652813L;

    public static final String SUCCESS = "OK";

    public static final String NUM_SUCCESS = "1";

    private @Getter
    Value value;

    private @Getter
    String resultCode;

    private @Getter
    boolean isException;

    private @Getter
    String exceptionMsg;

    private RedisResult(Value v, String resultCode) {
        this.resultCode = resultCode;
        this.value = v;
    }

    private RedisResult(boolean isException, String exceptionMsg) {
        this.isException = isException;
        this.exceptionMsg = exceptionMsg;
    }

    public static <T> RedisResult<T> create(T v) {
        return new RedisResult(v, SUCCESS);
    }

    public static <T> RedisResult<T> create(T v, String msg) {
        return new RedisResult(v, msg);
    }

    public static <T> RedisResult<T> createError(String errorMsg) {
        return new RedisResult(true,  errorMsg);
    }

    public boolean isSuccess() {
        if(isException) {
            return false;
        }
        return SUCCESS.equals(resultCode) || NUM_SUCCESS.equals(resultCode);
    }

    /**
     * 当 key 不存在时，返回 -2 。
     当 key 存在但没有设置剩余生存时间时，返回 -1 。否则，以秒为单位，返回 key 的剩余生存时间。
     */
    public static class TtlResult {
    }

}
