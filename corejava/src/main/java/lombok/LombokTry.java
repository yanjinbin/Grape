package lombok;

/**
 * 使用方法说明
 * https://goo.gl/s7avNa
 *
 * @author Silver & Bullet
 *         on 三月-21
 */
public class LombokTry {
    public static void main(String[] args) {
        //   Student 颜巾斌 = new Student().setAge(1).setId(12).setName("颜巾斌")
        Student student = Student.builder().age(11).name("hah").id(1).build();

    }
}
