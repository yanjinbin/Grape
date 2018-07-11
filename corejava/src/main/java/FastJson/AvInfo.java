package FastJson;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaobin
 * @Since 04-24
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AvInfo {
    @JSONField(name = "take_time")
    private Long takeTime;

    private Integer uid;

    private Long avID;
}
