package chapter2;

/**
 * @Author Silver bullet
 * @Since 2017/6/23.
 */
public class Test {
    public static void main(String[] args) {
        // 用 builder 风格写法的构建器来避免创建更多的构造函数
        // P11已经良好的说明了这个方法，先冻结对象，然后解冻，可以避免线程不安全
        Person person = Person.builder().age(11).height(11L).name("把球给我").build();

        Utility.showInfo();

     //   Utility.getInstance();
    }
}
