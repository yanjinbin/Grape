package chapter6;

/**
 * 用 Enum 代替 int 枚举模式的不足之处
 *
 * 用 Enum 代替 switch 语句  可以 避免 switch 语句的尴尬
 *
 * effective java    P132
 *
 * @Author Silver bullet
 * @Since 2017/6/27.
 */
public enum Operation {

    PLUS("+") {
        @Override
        double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        double apply(double x, double y) {
            return x - y;
        }
    };

    abstract double apply(double x, double y);

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return this.symbol;
    }
}
