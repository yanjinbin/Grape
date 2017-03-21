package lombok;

/**
 *
 * lombok 注解@Builder 的风骚写法
 * @author Silver & Bullet
 *         on 三月-21
 */
@Data
public class Person {
    private int age;

    private String name;

    public static class Builder {
        private int age;

        private String name;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Person build() {
            Person person = new Person();
            person.setAge(age);
            person.setName(name);
            return person;

        }

    }
}
