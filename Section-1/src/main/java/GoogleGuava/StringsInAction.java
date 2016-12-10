package GoogleGuava;

import com.google.common.base.Joiner;

/**
 * Created by dabin on 2016/12/10.
 */
public class StringsInAction {
    public static void main(String[] args) {
        System.out.println("嘿嘿");
    }
    public static void printJoinerFun(){
        Joiner joiner = Joiner.on(";").useForNull(null);
        String join = joiner.join("Harry", "John");
        System.out.println(join);
    }
}
