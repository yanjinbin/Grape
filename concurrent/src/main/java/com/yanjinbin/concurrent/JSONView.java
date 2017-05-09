package com.yanjinbin.concurrent;


import lombok.Data;

/**
 * Created by yanjinbin on 2017/4/29.
 */
@Data
public class JSONView<V> {
    public Integer code;
    public String msg;
    public V v;

    public JSONView(Integer code, String msg, V v) {
        this.code = code;
        this.msg = msg;
        this.v = v;
    }

    public static <V> JSONView<V> creatSuccess(V v, String msg) {
        return new JSONView<V>(StateCode.SUCCESS,msg,v);
    }

    public static <V> JSONView<V> createFail(String msg) {
        return new JSONView<V>(StateCode.Fail,msg,null);
    }

    public static class StateCode {
        public final static Integer SUCCESS = 1;
        public final static Integer Fail = -1;
    }
}
