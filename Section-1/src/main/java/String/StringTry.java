package String;

import java.nio.charset.Charset;

/**
 * @author Silver Bullet
 * @since 一月-06
 */
public class StringTry {
    public static void main(String[] args) {
        String str= "abcdefghijklmnopqrstuvwxyza";
        int length = str.length();
        System.out.println("length   "+length);
        char c = str.charAt(0);
        System.out.println("char   "+c);
        char last = str.charAt(length - 1);
        System.out.println("last char    "+last);
        int codePointAt = str.codePointAt(0);
        System.out.println("code point at 0 is      "+codePointAt );
        String concat = str.concat("1234567");
        System.out.println("concat str is       "+concat);
        boolean sfdgf = str.contains("sfdgf");
        System.out.println("has   ?      "+sfdgf);
        String endwith = "567";
        boolean endsWith = str.endsWith(endwith);
        System.out.println("ends with "+(endwith)+"      "+(endsWith));

        int i = 0 ;
        byte[] strBytes = str.getBytes();
        for (byte item:
        strBytes){
            System.out.println("byte "+(i++)+(" is    ")+item);
        }


        byte[] strBytes1 = str.getBytes(Charset.forName("UTF-8"));
        int j = 0 ;
        byte[] strBytesEncode = str.getBytes();
        for (byte item:
                strBytesEncode){
            System.out.println("byte "+(j++)+(" is    ")+item);
        }
        int codePointBefore = str.codePointBefore(1);


        System.out.println("codePointbefore       "+codePointBefore);
        int m = str.indexOf(1);
        System.out.println("index of 1  m is      "+m);
        int a = str.indexOf("a");
        System.out.println(a);
        int a1 = str.lastIndexOf("a");
        System.out.println(a1);

        System.out.println(str);
        System.out.println(concat.endsWith("567"));
        String intern = str.intern();
        System.out.println(intern);
        CharSequence charSequence = str.subSequence(0, 5);
        System.out.println(charSequence);

        System.out.println(str.toUpperCase());

    }
}
