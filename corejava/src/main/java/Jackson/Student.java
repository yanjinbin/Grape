package Jackson;

import lombok.Data;

import java.util.Date;

/**
 * @author xiaobin
 * @since 05-17
 */
@Data
public class Student {

    private int age;

    private String name;

    private Date birthDay;

    private int class_id;
}
