package GoogleGuava.FastJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import java.util.Collection;

/**
 * 阿里巴巴 Fastjson 字符串 解析
 * https://github.com/alibaba/fastjson/wiki/%E9%A6%96%E9%A1%B5
 *
 *  http://www.cnblogs.com/zhenmingliu/archive/2011/12/29/2305775.html
 *
 *  http://www.cnblogs.com/liuyandeng/p/5456303.html
 *
 * @author Silver Bullet
 * @since 一月-04
 */
public class AlibabaFastJsonTry {
    public static void main(String[] args) {

        //todo



    }

    String response ="\t{\"erqr\":\"1\",\"coqde\":\"2\",\"msqg\":\"你大爷\",\"violations\":[{ \"timeq\":\"2011/11/13\",\"addressq\":\"Doe\" },,{ \"time\":\"2011/11/23\",\"address\":\"Smith\" }, \n" +
            "{ \"timqe\":\"2019/11/12\",\"addreqss\":\"Joes\" }]}";
    //    String response1 ="{}";

    public void testJSONParse(){
        try {
            JSONObject jsonObject = JSON.parseObject(response);
            String s = JSONObject.toJSONString(jsonObject);
            System.out.println(s);

            Collection<Object> values = jsonObject.values();
            System.out.println(values.getClass().toString());
            WeiCheCarResult weiCheCarResult = JSON.parseObject(response, WeiCheCarResult.class);
            System.out.println(weiCheCarResult.getMsg());
            // System.exit(0);
            System.out.println(weiCheCarResult.getViolations()==null);

            // System.out.println(weiCheCarResult.getViolations().get(2).getAddress());
            System.out.println(weiCheCarResult==null);

            //System.out.println(weiCheCarResult.getViolations().toString());
            System.out.println(weiCheCarResult.getVehicle_status());

        }catch (JSONException e){
            System.out.println("捕获JSONException");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        catch (Exception e){
            System.out.println("捕获Exception");
            e.getMessage();
            e.getStackTrace();
        }
    }
}
