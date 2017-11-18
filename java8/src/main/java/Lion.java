import lombok.Builder;
import lombok.Data;

/**
 * @Author Grape
 * @Since 2017/8/11.
 */
@Data
@Builder
public class Lion implements Animal {

    public int age;

    private String name;

    @Override
    public void accept() {
        System.out.println("狮子名字\t\t" + name+"年龄"+age);
    }
}
