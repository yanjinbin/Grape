package FastJson;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Silver Bullet
 * @since 一月-05
 */
@Data
public class Group {

    private Long id;

    // 序列化属性的时候,指定如何被序列化
    @JSONField(serializeUsing = GroupValueSerializer.class)
    private String name;

    private List<User> userList =new ArrayList<User>();

    public void addUser(User user){
        userList.add(user);
    }
}
