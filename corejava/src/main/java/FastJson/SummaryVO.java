package FastJson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 吉利不布吉
 * @since 2017/12/20
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SummaryVO {
    //违规金额
    private double breachMoney;
    // 当月收入
    private  double income;
    //累计收入
    private  double totalIncome;
    //待提现
    private  double waitWithdraw;

}
