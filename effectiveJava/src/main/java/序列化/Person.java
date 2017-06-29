package 序列化;

import lombok.Builder;

import java.io.Serializable;

/**
 * @Author Silver bullet
 * @Since 2017/6/29.
 */
@Builder
public class Person implements Serializable {

    private int age;

    private String name;

    private double height;
}
