package Foundation;

/**
 * 位运算
 * 逻辑与、逻辑或、逻辑非是对boolean值得操作，属于离散数学范畴。
 * 按位与、按位或、按位非是对计算机位的操作，属于计算机二进制位运算范畴。
 * <p>
 * http://wiki.jikexueyuan.com/project/java/basic-operators.html
 * <p>
 * 源码补码反码: https://goo.gl/eiPHFz
 * Java运算符大全的使用规则: https://goo.gl/A5vPcu
 *
 * @author Silver & Bullet
 *         since 2016-十二月
 */
public class BasicOperatorTry {

    public static void main(String[] args) {
        //左移运算符
        //java 默认是int
        int test = 5;
        int bitMove = 2;
        String s = Integer.toBinaryString(test);
        System.out.println("二进制值------      " + s);
        int i = test << bitMove;//低位补0
        System.out.println("左移运算结果-----    " + i);
        //右移运算符
        int j = test >> bitMove;//高位补0
        System.out.println("右移运算结果-----   " + j);
        // 无符号右移，忽略符号位，空位都以0补齐
        int noSymbolValue = -5;//反码表示
        String binaryString = Integer.toBinaryString(noSymbolValue);
        System.out.println("二进制值------    " + binaryString);
        int k = noSymbolValue >>> 2;
        System.out.println("无符号右移运算结果-----   " + k);
        //无符号左移  没有无符号左移 运算符
        //    int nullString = noSymbolValue <<< 2;

        //位与
        System.out.println("位与运算结果-----   " + (5 & 3));
        //位或
        System.out.println("位或运算结果------   " + (5 | 3));
        //位非 ,注意位非是一元操作符
        System.out.println("位非运算结xx果-------   " + (~5));
        //位异或
        System.out.println("位异或结果-----    " + (5 ^ 3));
        //短语与 逻辑与  按位与 按位或 https://goo.gl/KYRNtd


        //由位运算符衍生而来的
//        &= 按位与赋值
//        |=  按位或赋值
//        ^= 按位非赋值
//         >>= 右移赋值
//         >>>= 无符号右移赋值
//         <<= 赋值左移
    }
}
