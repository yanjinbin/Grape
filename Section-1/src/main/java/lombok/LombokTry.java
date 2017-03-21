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
        //   Student 颜巾斌 = new Student().setAge(1).setId(12).setName("颜巾斌");
        Student student = Student.build().setName("颜巾斌").setId(1).setAge(12);
        Student primaryStudent = Student.builder().age(21).id(11).name("我来了").build();

    }
}
