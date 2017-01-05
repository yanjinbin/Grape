package FastJson;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONSerializable;
import com.alibaba.fastjson.serializer.JSONSerializer;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @author Silver Bullet
 * @since 一月-05
 */


//fastjson 对枚举类序列化的定制
public  enum OrderType implements JSONSerializable {
    PayOrder(1, "支付订单"), //
    SettleBill(2, "结算单");

    public final int    value;
    public final String remark;

    private OrderType(int value, String remark){
        this.value = value;
        this.remark = remark;
    }

  @Override
    public void write(JSONSerializer serializer, Object fieldName, Type fieldType,
                      int features) throws IOException {
        JSONObject json = new JSONObject();
        json.put("value", value);
        json.put("remark", remark);
        serializer.write(json);
    }

}