package CommonUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by Silver & Bullet
 * since 2016-十二月
 */
public class JSONUtil {

    public final static <T> List<T> beanCollections(Collection<Map> mapList, Class<T> clazz){
        String json = JSONObject.toJSONString(mapList);
        List<T> tList = JSON.parseArray(json, clazz);
        return tList;
    }
}
