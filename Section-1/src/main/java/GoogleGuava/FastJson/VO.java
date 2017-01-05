package GoogleGuava.FastJson;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @author Silver Bullet
 * @since 一月-05
 */
@Data
public class VO {
    private boolean isRight;

    private Integer age;

    @JSONField(label = "normal")
    private String name;


    @JSONField(label = "secret")
    private String secret;
}
