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
public class OperDuration {

    private Long avID;

    private Integer uid;

    @JSONField(name = "take_time")
    private Long takeTime;
}
