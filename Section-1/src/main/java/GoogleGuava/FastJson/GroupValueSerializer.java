package GoogleGuava.FastJson;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @author Silver Bullet
 * @since 一月-05
 */
public class GroupValueSerializer implements ObjectSerializer {
    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        String name = (String) object;
        String text = "姓名是   "+name;
        serializer.write(text);
    }
}
