package chapter2;

/**
 * @Author Silver bullet
 * @Since 2017/6/23.
 */
public class Utility {
    private Utility(){
        throw new IllegalStateException("不允许被实例化");
    }

    public static Utility getInstance(){
        return new Utility();
    }
    public static void showInfo(){
        System.out.println("哈哈---2017-06-23 20:08:21");
    }

    public void throwEx(){
        System.out.println("抛出异常--2017-06-23 20:09:37");
    }
}
