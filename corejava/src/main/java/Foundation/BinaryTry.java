package Foundation;

/**
 * 原码  补码  反码
 * http://dwz.cn/5diD6T
 * @author Silver & Bullet
 *         on 二月-05
 */
public class BinaryTry {
    public static void main(String[] args) {
        Integer i = 3;
      //  System.out.println(i.byteValue());
        System.out.println("Integer showed by BinaryString is     "+Integer.toBinaryString(i));
        Integer j = -3;
        String s = Integer.toBinaryString(j);
        System.out.println(s);
        // & 0xff
        Integer a =-127;
        System.out.println("-127的二进制:    "+Integer.toBinaryString(a));
        System.out.println("-127的16进制:    "+Integer.toHexString(15));
        int rs = a & 0xFF;
        System.out.println(rs);
        System.out.println(Integer.toBinaryString(rs));


    }
}
