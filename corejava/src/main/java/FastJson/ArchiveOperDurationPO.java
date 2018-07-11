package FastJson;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author xiaobin
 * @Since 04-24
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArchiveOperDurationPO {

    private Integer round;

    @JSONField(name = "avOper")
    private List<AvInfo> avInfos;

}
