package Reflection;

/**
 * Created by Silver & Bullet
 * since 2016-十一月
 */
public class Person {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void print(){
        System.out.println("print函数");
    }
}
