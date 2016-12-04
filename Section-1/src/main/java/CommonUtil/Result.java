package CommonUtil;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by luobin.lzb on 15-5-25.
 */
public class Result<Value> implements Serializable {
    private static final long serialVersionUID = 6006894164531652812L;

    public static final int FAILED = -1;
    //成功
    public static final int SUCCESS = 1;

    //未登录
    public static final int UN_LOGIN = 2;

    public static final int UN_LOGIN_WX = 99;

    public static final String UN_LOGIN_MSG = "请登陆";

    //已登录
    public static final int LOGINED = 3;
    //系统异常
    public static final int SYSTEM_ERROR = 4;

    public static final String SYSTEM_ERROR_MSG = "系统异常，请刷新重试";

    public static final String REQ_PRA_ERROR_MSG = "请求参数缺失";
    //不存在的用户
    public static final int UN_EXIST = 5;
    //用户名或密码不匹配
    public static final int UN_MATCHED = 6;
    //已经注册
    public static final int REGISTED = 7;
    //认证码错误
    public static final int AUTH_CODE_ERROR = 8;
    //全局Cookie没有
    public static final int NON_REQUIRED_COOKIE = 10;
    //扫码登陆uuid不存在
    public static final int UUID_NOT_EXIST = 11;
    //第三方平台登录uid不存在，参数不全
    public static final int PLATFORM_Uid_NULL = 12;
    //第三方登录失败
    public static final int PLATFORM_LOGIN_FAIL = 13;
    //参数不全 。全局token不存在
    public static final int NON_REQUIRED_TOKEN = 14;
    //注册信息数据格式异常
    public static final int REG_INFO_FORMAT_ERROR = 15;
    //第三方登陆信息异常
    public static final int LOGIN4_THIRD_PLATFORM_INFO_ERROR = 16;
    //找回密码信息数据格式异常
    public static final int FINDPWD_INFO_FORMAT_ERROR = 17;
    //参数类型不匹配
    public static final int PARAMATER_FORMAT_ERROR = 18;
    //短信发送限制（发送频率太快被限制）
    public static final int MSG_SEND_FREQUENCE_LIMIT = 19;
    //回复失败
    public static final int REPLY_FAIL = 20;
    //已经赞过
    public static final int LIKED = 21;
    //手机号码已经被绑定
    public static final int MOBILE_IS_BINDED = 22;
    //会员信息不匹配
    public static final int USER_NOT_FIT = 24;
    //原密码不正确
    public static final int ORI_PASSWORD_NOT_CORRECT = 25;

    public static final int ILEAGL_KEY = 26;
    //数据签名错误
    public static final int REQ_SIGN_ERROR = 29;
    //数据解析错误
    public static final int DATA_ERROR = 45;
    //没有找到对应值
    public static final int NOT_FOUND = 403;
    //非法的请求
    public static final int BAD_REQUEST = 500;
    //无效的请求
    public static final int INVALID_REQUEST = 404;
    //请求参数错误
    public static final int REQ_PARA_ERROR = 400;


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

    public static <T> Result<T> createSystemError() {
        return createError("系统错误", SYSTEM_ERROR);
    }

    public static <T> Result<T> requestParamError() {
        return createError(REQ_PRA_ERROR_MSG, REQ_PARA_ERROR);
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
