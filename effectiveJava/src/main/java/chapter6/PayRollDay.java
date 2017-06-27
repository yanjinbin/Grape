package chapter6;

/**
 *
 * //effective java P135  讲述了这种方法 当遇到特殊情况的时候
 *
 * @Author Silver bullet
 * @Since 2017/6/27.
 */
public enum PayRollDay {
    MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY;
    private final static int HOURS_PER_SHIFT = 8 ;
    double pay(double hoursWorked,double payRate){
        double  basePay = hoursWorked * payRate;
        double overTimePay;
        switch (this){
            case SATURDAY:case SUNDAY:
                overTimePay = hoursWorked *payRate/2;
                default:
                    overTimePay = hoursWorked <= HOURS_PER_SHIFT/2?0:(hoursWorked-HOURS_PER_SHIFT)*payRate/2;
                    break;
        }
        return  basePay+overTimePay;
    }
}
