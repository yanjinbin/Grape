package CommonUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 快速参考链接 https://goo.gl/LDQl4g  https://goo.gl/da36d5(java的正则表达式语法) https://goo.gl/6QYgMD(20个常用的正则表达式)
 * Created by Silver & Bullet
 * since 2016-十二月
 */
public class RegexUtil {

    //校验密码强度，规则：包含大小写字母和数字的组合，不能使用特殊字符，长度在8-10之间
    public static Boolean isPasswordValid(String password) {
        String passwordPattern = "^(?=.*\\d).(?=.*[a-z]).(?=.*[A-Z]).{8,10}$";
        Pattern p = Pattern.compile(passwordPattern);
        Matcher m = p.matcher(password);
        return m.matches();
    }

    //18位身份证校验规则
    public static Boolean isIdCardValid(String identityCard) {
        String idCardPattern = "^[1-9]\\\\d{5}[1-9]\\\\d{3}((0\\\\d)|(1[0-2]))(([0|1|2]\\\\d)|3[0-1])\\\\d{3}([0-9]|X)$";
        Pattern p = Pattern.compile(idCardPattern);
        Matcher matcher = p.matcher(identityCard);
        return matcher.matches();
    }

    public static Boolean isIP4Valid(String ip) {
        String ip4pattern = "\\\\b(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\\\b";
        Pattern p = Pattern.compile(ip4pattern);
        Matcher m = p.matcher(ip);
        return m.matches();
    }

    public static Boolean isEmailInvalid(String email) {
        String emailPattern = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p = Pattern.compile(emailPattern);
        Matcher m = p.matcher(email);
        return m.matches();
    }
}
