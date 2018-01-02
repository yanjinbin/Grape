package com.yanjinbin;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by luobin.lzb on 15-5-25.
 */
public class Result<Value> implements Serializable {

    public static final int FAILED = -1;
    //成功
    public static final int SUCCESS = 1;


    private
    @Getter
    boolean isSuccess;

    private
    @Getter
    String msg;

    private
    @Getter
    @Setter
    Value value;

    private
    @Getter
    int rc;

    private
    @Getter
    Map<String, String> exts = new HashMap<String, String>();

    private
    @Setter
    @Getter
    boolean hasMore;

    private Result(Value v, String msg) {
        this(true, v, msg, SUCCESS);
    }

    public Result(boolean isSuccess, Value v, String msg, int rc) {
        this.isSuccess = isSuccess;
        this.msg = msg;
        this.value = v;
        this.rc = rc;
    }


    public static <T> Result<T> createSuccess(T v, int rc) {
        return new Result(true, v, "SUCCESS", rc);
    }

    public static <T> Result<T> createSuccess(T v) {
        return new Result(true, v, "SUCCESS", SUCCESS);
    }

    public static <T> Result<T> createSuccess(T v, String msg) {
        return new Result<T>(true, v, msg, SUCCESS);
    }

    public static <T> Result<T> createError(String msg, int rc) {
        return new Result<T>(false, null, msg, rc);
    }

    public static <T> Result<T> createError(String msg, int rc, T v) {
        return new Result<T>(false, v, msg, rc);
    }


    public static <T> Result<T> readDBFailed() {
        return createError("读取数据失败", FAILED);
    }

    public String getExt(String key) {
        return exts.get(key);
    }

    public void addExt(String key, String value) {
        this.exts.put(key, value);
    }

}
