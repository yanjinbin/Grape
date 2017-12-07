import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/** master test  2017年2月24日 10:31:50
 * @author Silver Bullet
 * @since 一月-10
 */
public class Test implements Serializable {

    //2017年02月27日17:24:48

    private static final long serialVersionUID = 2010307013874058143L;


    public static void main(String[] args) {
        String s1 ="ab"+"c";
        String s2 = "abc";
        System.out.println(s1==s2+":"+s1.equals(s2));
        long fromTime = 1511254613;
        SimpleDateFormat  sdf= new SimpleDateFormat();
        String format = sdf.format(new Date(fromTime));
        System.out.println(format);

    }
}
