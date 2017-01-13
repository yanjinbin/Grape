package FastJson;

import CommonUtil.Constants;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.serializer.Labels;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import org.junit.Assert;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.*;

/**
 * 阿里巴巴 Fastjson 字符串 解析
 * https://github.com/alibaba/fastjson/wiki/%E9%A6%96%E9%A1%B5
 * <p>
 * http://www.cnblogs.com/zhenmingliu/archive/2011/12/29/2305775.html
 * <p>
 * http://www.cnblogs.com/liuyandeng/p/5456303.html
 * <p>
 * <p>
 * JSONObject和 JSONArray的区别 https://my.oschina.net/sulliy/blog/499834
 * 在spring mvc中 使用 FastJsonHttpMessageConverter 对数据进行序列化和去序列化
 * <p>
 * FastJson是一个Java语言编写的高性能功能完善的JSON库。它采用一种“假定有序快速匹配”的算法，把JSON Parse的性能提升到极致，是目前Java语言中最快的JSON库。FastJson接口简单易用，已经被广泛使用在缓存序列化、协议交互、Web输出、Android客户端等多种应用场景。
 *
 * @author Silver Bullet
 * @since 一月-04
 */
public class AlibabaFastJsonTry {
    public static void main(String[] args) {

        //todo
        Group group = new Group();
        group.setId(0L);
        group.setName("admin");

        User guestUser = new User();
        guestUser.setId(2L);
        guestUser.setName("guest");
        LocalDate now = LocalDate.now();
        System.out.println("localdate  is   " + now);
        guestUser.setLocalDate(now);

        System.out.println("guest user is   " + JSON.toJSONString(guestUser));

        System.out.println("JSONArray toJSONString is     " + JSONArray.toJSONString(guestUser));


        User rootUser = new User();
        rootUser.setName("root");
        rootUser.setId(3L);
        LocalDate designedLocadate = LocalDate.of(2016, 11, 12);
        System.out.println("designed localdate is    " + designedLocadate);
        rootUser.setLocalDate(designedLocadate);
        System.out.println("root user is   " + JSON.toJSONString(rootUser));
        group.addUser(guestUser);
        group.addUser(rootUser);


        String jsonString = JSON.toJSONString(group);

        System.out.println("JSON.toJSONString     " + jsonString);

        String s2 = JSONArray.toJSONString(group);

        System.out.println("JSONArray toJSONString is     " + s2);

        List<User> users = new ArrayList<User>();
        users.add(guestUser);
        users.add(rootUser);

        //没区别
        System.out.println("----我来了---" + JSONArray.toJSONString(users));
        System.out.println("----你说呢-----" + JSON.toJSONString(users));

        Group group1 = JSON.parseObject(jsonString, Group.class);


        //处理时间
        Date date = new Date();
        System.out.println(date);
        String s = JSON.toJSONStringWithDateFormat(date, Constants.TimeFormat.hyphenSeparate);
        System.out.println("Hyphen- separate  dateStr is      " + s);


        String iso8601DateStr = JSON.toJSONString(date, SerializerFeature.UseISO8601DateFormat);
        System.out.println("iso8601 date str  is        " + iso8601DateStr);

        // diy  要被序列化的属性
        SimplePropertyPreFilter simplePropertyPreFilter = new SimplePropertyPreFilter(User.class, "name");
        Set<String> excludes = simplePropertyPreFilter.getExcludes();
        Set<String> includes = simplePropertyPreFilter.getIncludes();
        System.out.println("-----exclude---");
        for (String item :
                excludes) {

            System.out.println(item);
        }
        System.out.println("---include--");

        for (String item :
                includes) {

            System.out.println(item);
        }
        String diyPropertyFilter = JSON.toJSONString(guestUser, simplePropertyPreFilter);
        System.out.println(diyPropertyFilter);


        //  Assert.assertEquals("{\"name\":\"guest\"}",JSON.toJSONString(guestUser,simplePropertyPreFilter));

        //序列化属性定制参加 User 和Group类

        //custom enum NIO.serializable
        System.out.println("---------enum custom srerializable ");
        Model model = new Model();
        model.id = 1001;
        model.orderType = OrderType.PayOrder;
        System.out.println(JSON.toJSONString(model));


        //不同场景下序列化 定制  Label标签的使用


        VO vo = new VO();
        vo.setName("江主席");
        vo.setAge(16);
        vo.setRight(true);
        vo.setSecret("123456");
        String normal = JSON.toJSONString(vo, Labels.includes("normal"));
        System.out.println("json normal is     " + normal);

        String secret = JSON.toJSONString(vo, Labels.excludes("secret"));
        System.out.println("json secret is       " + secret);

        //JSONPATH 使用


        //FieldTypeResolver 使用


        FieldTypeResolver fieldResolver = new FieldTypeResolver() {
            public Type resolve(Object object, String fieldName) {
                if (fieldName.startsWith("item_")) { // 字段名称为item_开始的对象，识别类型为Item
                    return Item.class;
                }

                return null;
            }
        };

        String text = "{\"item_0\":{},\"item_1\":{},\"item_2\":1001}";
        JSONObject o = JSON.parseObject(text, JSONObject.class, fieldResolver);
        Assert.assertTrue(o.get("item_0") instanceof Item);
        Assert.assertTrue(o.get("item_1") instanceof Item);
        Assert.assertTrue(o.get("item_2") instanceof Integer);

        //关闭全局的循环检测


        //fastjson 循环引用导致的stackoverflow 异常问题 解决办法  fastjson默认开启循环检测,来处理stackoverflow异常

        //什么是循环引用

        //  参考这个链接 解决之   https://my.oschina.net/xunzhizhe/blog/809100


        //json 对 java nio包 inputstream writer 和outputstream的支持


        //ParseToExistingObject

        // JSON_writeJSONString_cn
        //JSON_parseObject_InputStream_cn
        //https://github.com/alibaba/fastjson/wiki/JSON_parseObject_InputStream_cn

//        //处理超大json文本
//        // https://github.com/alibaba/fastjson/wiki/Stream-api
//
//        //超大json数组序列化
//        try {
//            JSONWriter jsonWriter = new JSONWriter(new FileWriter("/temp/huge.json"));
//            jsonWriter.startArray();
//            for (int i = 0; i < 1000 * 1000; i++) {
//                jsonWriter.writeValue(new VO());
//            }
//            jsonWriter.endArray();
//            jsonWriter.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        //超大json数组  对应的反序列化
//
//        try {
//            JSONReader reader = new JSONReader(new FileReader("/tmp/huge.json"));
//            reader.startArray();
//            while (reader.hasNext()) {
//                VO vo = reader.readObject(VO.class);
//                // handle vo ...
//            }
//            reader.endArray();
//            reader.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//
//        // 循环引用导致的stackoverflow 问题 解决办法
//
//        //https://github.com/alibaba/fastjson/wiki/%E5%BE%AA%E7%8E%AF%E5%BC%95%E7%94%A8
//
//
//        //ParseProcess  处理多余字段


//
//        //超大json对象序列化
//
//
//        try {
//            JSONWriter writer = new JSONWriter(new FileWriter("/tmp/huge.json"));
//            writer.startObject();
//            for (int i = 0; i < 1000 * 1000; ++i) {
//                writer.writeKey("x" + i);
//                writer.writeValue(new VO());
//            }
//            writer.endObject();
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        //超大json对象反序列化
//
//        try {
//            JSONReader   reader = new JSONReader(new FileReader("/tmp/huge.json"));
//            reader.startObject();
//            while(reader.hasNext()) {
//                String key = reader.readString();
//                VO vo = reader.readObject(VO.class);
//                // handle vo ...
//            }
//            reader.endObject();
//            reader.close();
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//
//        //将非string类型转换成String类型
//        //https://github.com/alibaba/fastjson/wiki/SerializerFeature_FAQ_CN
//
//        VO vo = new VO();
//        vo.setRight(true);
////        vo.setAge(18);
////        vo.setName("哈哈");
//
//        String s1 = JSON.toJSONString(vo, SerializerFeature.WriteNonStringValueAsString);
//        System.out.println("s1  with SerializerFeature.WriteNonStringValueAsString        " + s1);
//
//        String s2 = JSON.toJSONString(vo);
//        System.out.println("s2  default SerializerFeature is   " + s2);


    }

    String response = "\t{\"erqr\":\"1\",\"coqde\":\"2\",\"msqg\":\"你大爷\",\"violations\":[{ \"timeq\":\"2011/11/13\",\"addressq\":\"Doe\" },,{ \"time\":\"2011/11/23\",\"address\":\"Smith\" }, \n" +
            "{ \"timqe\":\"2019/11/12\",\"addreqss\":\"Joes\" }]}";
    //    String response1 ="{}";

    public void testJSONParse() {
        try {
            JSONObject jsonObject = JSON.parseObject(response);
            String s = JSONObject.toJSONString(jsonObject);
            System.out.println(s);

            Collection<Object> values = jsonObject.values();
            System.out.println(values.getClass().toString());
            WeiCheCarResult weiCheCarResult = JSON.parseObject(response, WeiCheCarResult.class);
            System.out.println(weiCheCarResult.getMsg());
            // System.exit(0);
            System.out.println(weiCheCarResult.getViolations() == null);

            // System.out.println(weiCheCarResult.getViolations().get(2).getAddress());
            System.out.println(weiCheCarResult == null);

            //System.out.println(weiCheCarResult.getViolations().toString());
            System.out.println(weiCheCarResult.getVehicle_status());

        } catch (JSONException e) {
            System.out.println("捕获JSONException");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        } catch (Exception e) {
            System.out.println("捕获Exception");
            e.getMessage();
            e.getStackTrace();
        }


        //利用FastJson 实现spring mvc http message convert

    }
}
