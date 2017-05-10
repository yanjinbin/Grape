package lombok;

import lombok.experimental.Accessors;

/**
 * @author Silver & Bullet
 *         on 三月-21
 */
@Data
@Builder
@Accessors(chain = true)
public class Student {

    private int age;

    private String name;

    private int id;
}
