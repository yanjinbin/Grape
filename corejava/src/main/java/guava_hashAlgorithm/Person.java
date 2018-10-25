package guava_hashAlgorithm;

import com.google.common.base.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equal(firstName, person.firstName) &&
                Objects.equal(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, firstName, lastName);
    }
}