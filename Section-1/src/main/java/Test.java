import java.io.Serializable;

/** master test  2017年2月24日 10:31:50
 * @author Silver Bullet
 * @since 一月-10
 */
public class Test implements Serializable {

    private static final long serialVersionUID = 2010307013874058143L;


    public static void main(String[] args) {
   /*     String replace = UUID.randomUUID().toString().replace("-", "");
        System.out.println(replace.length());*/
        String s1 ="ab"+"c";
        String s2 = "abc";
        System.out.println(s1==s2+":"+s1.equals(s2));



    }
}
