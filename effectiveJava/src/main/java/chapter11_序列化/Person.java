package chapter11_序列化;

import lombok.Builder;

import java.io.Serializable;

/**
 * @Author Silver bullet
 * @Since 2017/6/29.
 */
@Builder
public class Person implements Serializable {

    // 不可序列化
    public final transient String family;

    private int age;

    private String name;

    private double height;
}
