package FastJson;

import com.alibaba.fastjson.JSON;

/**
 * @author 吉利不布吉
 * @since 2018/2/7
 */
public class NullParse {

    public static void main(String[] args) {
        String json = "{\"code\":0,\"data\":{\"income\":null,\"totalIncome\":null,\"waitWithdraw\":null,\"breachMoney\":null},\"message\":\"ok\"}";
        SummaryRs summaryRs = JSON.parseObject(json, SummaryRs.class);
        System.out.println(summaryRs.getData().getIncome());

    }
}
