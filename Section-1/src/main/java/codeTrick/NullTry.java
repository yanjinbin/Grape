package codeTrick;

/**
 * @author Silver & Bullet
 *         on 三月-15
 */
public class NullTry {
    public static void greet() {
        System.out.println("Hello world!"); }
    public static void main(String[] args) {
        NullTry x = null;
        //静态和非静态区别
        x.greetInstance();


        x.greet(); //(1)
        ((NullTry)x).greet();// (2)
        ((NullTry) null).greet(); //(3)


    }

    public void greetInstance(){
        System.out.println("hello - world ");
    }
}
