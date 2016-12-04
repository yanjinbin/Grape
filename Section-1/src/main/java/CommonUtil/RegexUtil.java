package CommonUtil;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 快速参考链接 https://goo.gl/LDQl4g  https://goo.gl/da36d5(java的正则表达式语法) https://goo.gl/6QYgMD(20个常用的正则表达式)
 * Created by Silver & Bullet
 * since 2016-十二月
 */
public  final class RegexUtil {

    public static final String password = "^(?=.*\\d).(?=.*[a-z]).(?=.*[A-Z]).{8,10}$";

    public static final String idCard = "^[1-9]\\\\d{5}[1-9]\\\\d{3}((0\\\\d)|(1[0-2]))(([0|1|2]\\\\d)|3[0-1])\\\\d{3}([0-9]|X)$";

    public static final String ip4 = "\\\\b(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\\\b";

    public static final String mobile_pattern = "^((17[0-9])|(18[0-9])|(14[0-9])|(13[0-9])|(15[0-9])|(18[0-9]))\\d{8}$";

    public static final String email = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    public static final String userName =""; //nextdo

    //校验密码强度，规则：包含大小写字母和数字的组合，不能使用特殊字符，长度在8-10之间
    public static Boolean checkPassword(String password) {
        Pattern p = Pattern.compile(RegexUtil.password);
        Matcher m = p.matcher(password);
        return m.matches();
    }

    //18位身份证校验规则
    public static Boolean checkIdCard(String identityCard) {
        if (StringUtils.isEmpty(identityCard)) {
            return false;
        }
        Pattern p = Pattern.compile(idCard);
        Matcher matcher = p.matcher(identityCard);
        return matcher.matches();
    }

    public static Boolean checkIP4(String ip) {
        if (StringUtils.isEmpty(ip)) {
            return false;
        }
        Pattern p = Pattern.compile(ip4);
        Matcher m = p.matcher(ip);
        return m.matches();
    }

    public static Boolean checkEmail(String email) {
        if (StringUtils.isEmpty(email)) {
            return false;
        }
        Pattern p = Pattern.compile(RegexUtil.email);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    public static Boolean checkUserName(String userName){
        if (StringUtils.isEmpty(userName)) {
            return false;
        }
        Pattern p = Pattern.compile(userName);
        Matcher m= p.matcher(userName);
        return m.matches();
    }

    public static Boolean checkPhone(String phone){
        if (StringUtils.isEmpty(phone)) {
            return false;
        }
        Pattern p = Pattern.compile(mobile_pattern);
        Matcher m = p.matcher(phone);
        return m.matches();
    }
}
