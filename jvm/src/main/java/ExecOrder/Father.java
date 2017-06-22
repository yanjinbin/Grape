package ExecOrder;

/**
 * @Author Silver bullet
 * @Since 2017/6/22.
 */
public class Father extends Family implements FamilyInterface{
    public final static String familyName="守望屁股";
    public void heiarch(){
        System.out.println(familyName);
    }


    //注意下这个区别  height 的 执行顺序 区别

   // public static int height =11;
    static{
        height =22;
    }
    public static int height =11;

}
