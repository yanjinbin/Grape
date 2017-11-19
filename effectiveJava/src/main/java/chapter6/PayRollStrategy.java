package chapter6;

/**
 * @Author Silver bullet
 * @Since 2017/6/27.
 */
public enum PayRollStrategy {

    // 工作日
    MONDAY(PayType.WEEKDAY),
    TUESDAY(PayType.WEEKDAY),
    // 假日
    HOLIDAY(PayType.WEEKEND),
    SATURDAY(PayType.WEEKEND);


    private final PayType payType;

    PayRollStrategy(PayType payType) {
        this.payType = payType;
    }

    double pay(double hours, double payRate) {
        return payType.pay(hours, payRate);
    }

    private enum PayType {
        //策略枚举模式
        WEEKDAY {
            @Override
            double overtimePay(double hours, double payRate) {
                return hours <= HOURS_PER_SHIFT ? 0 : (hours - HOURS_PER_SHIFT) / 2;
            }
        },
        WEEKEND {
            @Override
            double overtimePay(double hours, double payRate) {
                return hours * payRate / 2;
            }
        };

        private final static int HOURS_PER_SHIFT = 8;

        abstract double overtimePay(double hrs, double payRate);

        double pay(double hoursWorked, double payRate) {
            double basePay = hoursWorked * payRate;
            return basePay + overtimePay(hoursWorked, payRate);
        }
    }
}
