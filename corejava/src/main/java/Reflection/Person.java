package Reflection;

import lombok.Data;

/**
 * Created by Silver & Bullet
 * since 2016-十一月
 */
@Data
public class Person extends Parent {

    private String name;

    private int age;

    private void print(){
        System.out.println("print函数");
    }



}
