package CallBack;

import lombok.Data;

/**
 * @author Silver & Bullet
 *         on 十二月-25
 */
@Data
public class Student {
    private String name;
    private String age;
    public static void cal(int a ,int b){
        System.out.println("a+b is"+(a+b));
    }

    public static  void multiple(int a ,int b){

    }
}
