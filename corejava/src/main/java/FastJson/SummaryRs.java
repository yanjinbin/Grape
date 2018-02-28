package FastJson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 吉利不布吉
 * @since 2017/12/20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SummaryRs {

    private String message;

    private int code;

    private SummaryVO data;
}
