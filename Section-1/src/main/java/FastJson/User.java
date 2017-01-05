package FastJson;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author Silver Bullet
 * @since 一月-05
 */
@Data
@JSONType//对类的序列化定制
public class User {
    //制定序列化成json的排序,默认是按照fieldName 字母排序
    @JSONField(ordinal = 11)
    private Long id;
        //JSONField 介绍
    //  https://github.com/alibaba/fastjson/wiki/JSONField

    @JSONField(name = "ID啊你大野")
    private String name;
    //指定时间格式
    @JSONField(format = "yyyy/MM/dd")
    private LocalDate localDate;
    //支持不需要对json字符串进行再次json化
    //@JSONField(jsonDirect = true)  https://github.com/alibaba/fastjson/wiki/JSONField_jsonDirect_cn
    private String defaultJsonStr = "{ \"name\":\"菜鸟教程\" , \"url\":\"www.runoob.com\" }";
}
