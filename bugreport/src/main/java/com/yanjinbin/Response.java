package com.yanjinbin;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 视图模型
 *
 * @author Silver Bullet
 * @since 二月-27
 */
@Data
public final class Response<V> {
    @JSONField(serialize = false, deserialize = false)
    public boolean isSuccess;
    private Integer code;
    private String msg;
    private V info;

    public Response(boolean isSuccess, Integer code, V info, String msg) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.info = info;
        this.msg = msg;

    }


    public static <V> Response<V> createSuccess(V v, String msg) {
        return new Response<>(true, STATECODE.SUCCESS, v, msg);
    }

    public static <V> Response<V> createFail(String msg) {
        return new Response<>(false, STATECODE.FAIL, null, msg);
    }

    public static <V> Response<V> createSuccess() {
        return new Response<>(true, STATECODE.SUCCESS, null, null);
    }

    public static <V> Response createFail(Integer code, String msg) {
        return new Response(false, code, null, msg);
    }

    public static class STATECODE {
        public final static int FAIL = -1;
        public final static int SUCCESS = 0;
    }
}
