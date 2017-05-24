package guava_hashAlgorithm;

import lombok.Builder;
import lombok.Data;

/**
 * @Author Silver bullet
 * @Since 2017/5/16.
 */
@Data
@Builder
public class Person {

    private int id;

    private String firstName;

    private String lastName;

    private int birthYear;

}