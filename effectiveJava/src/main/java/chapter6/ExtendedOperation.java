package chapter6;

/**
 * @Author Silver bullet
 * @Since 2017/6/27.
 */
public enum ExtendedOperation implements Operations {

    EXP("^") {
        @Override
        public double apply(double x, double y) {
            return Math.pow(x, y);
        }
    },
    REMAINDER("%") {
        @Override
        public double apply(double x, double y) {
            return x % y;
        }
    };

    private final String symbol;

    ExtendedOperation(String symbol) {
        this.symbol = symbol;
    }


    @Override
    public String toString() {
        return this.symbol;
    }
}
