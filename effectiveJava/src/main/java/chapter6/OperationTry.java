package chapter6;

/**
 * @Author Silver bullet
 * @Since 2017/6/27.
 */
public class OperationTry {
    public static void main(String[] args) {
        double x = 2;
        double y = 4;

        for (Operation op : Operation.values()){
            System.out.printf("%f %s %f = %f%n",x,op,y,op.apply(x,y));
        }
    }
}
