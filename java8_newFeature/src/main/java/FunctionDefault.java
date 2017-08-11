/**
 * @Author Grape
 * @Since 2017/8/11.
 */


public class FunctionDefault implements Test, ConfictTest {

    public static void main(String[] args) {
        FunctionDefault impl = new FunctionDefault();
        impl.doSth();//hello
    }

    // 覆写冲突方法
    @Override
    public void doSth() {
        ConfictTest.super.doSth();
        // System.out.println("hi");
    }

//    // 覆写默认方法
//    @Override
//    public void doSth() {
//        System.out.println("hi");
//    }

}

interface Test {

    default void doSth() {
        System.out.println("hello");
    }
}

interface ConfictTest {

    default void doSth() {
        System.out.println("world");
    }
}

interface Test2 extends Test {
    @Override
    default void doSth() {
        System.out.println("hello2");
    }
}