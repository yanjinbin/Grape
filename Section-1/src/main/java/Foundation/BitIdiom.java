package Foundation;

/**
 * java 位移技巧
 * http://blog.csdn.net/zmazon/article/details/8262185
 *
 * @Author Grape
 * @Since 2017/7/24.
 */
public class BitIdiom {
    public static void main(String[] args) {

        int intMax = getIntMax();
        System.out.println(Integer.toBinaryString(getIntMin()));
    }

    public static int getIntMax() {
        return (1 << 31) - 1;
    }

    public static int getIntMin() {
        return 1 << 31;
    }

    public static int power2(int source) {
        return source << 1;
    }

    public static int divide2(int source) {
        return source >> 1;
    }

    public static int powerM(int source, int m) {
        return source << m;
    }

    public static int divideM(int source, int m) {
        return source >> m;
    }

    public static boolean isEven(int source) {
        return (source & 1) == 2;
    }

    public static boolean isOdd(int source) {
        return (source & 1) == 1;
    }

    public static int abs(int n) {
        return (n ^ (n >> 31)) - (n >> 31);
    }

    public static int max(int a, int b) {
        return b & ((a - b) >> 31) | a & (~(a - b) >> 31);
    /*如果a>=b,(a-b)>>31为0，否则为-1*/
    }

    // 判断符号为是不是的相同
    public static boolean isSameSign(int x, int y) { //有0的情况例外
        return (x ^ y) >= 0; // true 表示 x和y有相同的符号， false表示x，y有相反的符号。
    }

    // 求平均值
    public static int getAverage(int x, int y) {
        return (x + y) >> 1;
    }

    // 计算2的N次方
    public static int getFactorialofTwo(int n) {//n > 0
        return 2 << (n - 1);//2的n次方
    }

    //从低位到高位,取n的第m位
    public static int getBit(int n, int m) {
        return (n >> (m - 1)) & 1;
    }

    public static int setBitToOne(int n, int m) {
        return n | (1 << (m - 1));
    /*将1左移m-1位找到第m位，得到000...1...000
      n在和这个数做或运算*/
    }

    public static int setBitToZero(int n, int m) {
        return n & ~(1 << (m - 1));
    /* 将1左移m-1位找到第m位，取反后变成111...0...1111
       n再和这个数做与运算*/
    }
}
