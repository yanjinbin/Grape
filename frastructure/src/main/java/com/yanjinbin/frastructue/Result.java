package com.yanjinbin.frastructue;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * value is the return element
 * support Pagination and ext content
 * @param <Value>
 */
public class Result<Value> implements Serializable {

    public static final int FAILED = 0;
    //成功
    public static final int SUCCESS = 1;

    private
    @Getter
    String msg;

    private
    @Getter
    Value value;

    private
    @Getter
    int rc;

    private
    @Getter
    Map exts;

    private
    @Getter
    boolean has_more;

    private Result(Value v, String msg) {
        this(v, msg, SUCCESS);
    }


    public Result( Value v, String msg, int rc) {
        this.msg = msg;
        this.value = v;
        this.rc = rc;
        this.has_more =true;
    }

    public Result( Value v,  int rc,String msg) {
        this.msg = msg;
        this.value = v;
        this.rc = rc;
        this.has_more =true;
    }


    public Result( Value v, String msg, int rc,boolean has_more) {
        this.msg = msg;
        this.value = v;
        this.rc = rc;
        this.has_more = has_more;
    }

    public Result(Value v,String msg,int rc ,Map exts){
        this.value =v;
        this.msg = msg;
        this.rc =rc;
        this.exts = exts;
        this.has_more =true;
    }
    public Result(String msg,int rc ,Map exts){
        this.msg = msg;
        this.rc =rc;
        this.exts = exts;
        this.has_more =true;
    }
//
//    public Result(PageResult<Value> result, String msg, int rc) {
//        this.result = result;
//        this.msg = msg;
//        this.rc = rc;
//    }

    public Result(String msg, int rc) {
        this.msg = msg;
        this.rc = rc;
    }

    public static <T> Result<T> createSuccess(T v, int rc) {
        return new Result(v, "SUCCESS", rc);
    }

    public static <T> Result<T> createSuccess(T v) {
        return new Result(v,  SUCCESS,"success");
    }

    public static <T> Result<T> createSuccess(T v, String msg) {
        return new Result<T>(v, msg, SUCCESS);
    }

    public static <T> Result<T> createError(String msg, int rc) {
        return new Result<T>(msg, rc);
    }

    public static <T> Result<T> createError(String msg, int rc, T v) {
        return new Result<T>(v, msg, rc);
    }


    public static <T> Result<T> createSuccess(T  t, String msg, int rc , Map ext){
        return new Result<>(t,msg,rc,ext);
    }

    public static <T> Result<T> createSuccess(String msg, int rc , Map ext){
        return new Result<>(msg,rc,ext);
    }


    public static <T> Result<T> SUCCESS_PAGE(int total_record,int page_no,List<T> data){

        PageResult<T> pageResult = new PageResult<>(total_record, page_no, data);

        return  new Result(pageResult,"success",SUCCESS);
    }
    @Data
    public static class PageResult<T> {
        //总条数
        private int total_record;
        //数据
        private List<T> data;
        //页码
        private int page_no;

        public PageResult(int total_records,int page_no, List<T> data) {
            this.total_record= total_records;
            this.data = data;
            this.page_no = page_no;
        }

    }

}
