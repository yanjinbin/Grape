package springboot;

import lombok.Data;

/**
 * @author Silver Bullet
 * @since 三月-03
 */
@Data
public class User {
    private Integer id;
    private String name;
    private Integer age;

    public User( Integer id,Integer age, String name) {

        this.age = age;
        this.id = id;
        this.name = name;
    }
}
