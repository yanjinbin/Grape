package lombok;

import lombok.experimental.Accessors;

/**
 * @author Silver & Bullet
 *         on 三月-21
 */
@Data
@Accessors(chain = true)// 链式调用
@RequiredArgsConstructor(staticName = "build")
@Builder//builder 风格
public class Student {

    private int age;

    private String name;

    private int id;
}
