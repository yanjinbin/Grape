package chapter2;

/**
 * @Author Silver bullet
 * @Since 2017/6/23.
 */
public class Elvis {

    // 放至反序列化的时候 重新生成一个新的对象

    public transient static final Elvis INSTANCE = new Elvis();

    private Elvis() {
    }

    public void leaveTheBuilding() {
    }


    public static Elvis getInstance() {
        return INSTANCE;
    }

    private Object readSlove() {
        return INSTANCE;
    }

}
