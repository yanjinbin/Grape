/**
 * @Author Silver bullet
 * @Since 2017/6/22.
 */
public class Test {
    public static void main(String[] args) {
        Son son = new Son();
        son.show();
        son.showFamily();
        System.out.println(Son.age);
      //  System.out.println(Son.name);  jvm 虚拟机具体实现更加严格 不允许 不明确匹配
        System.out.println(Son.age);
    }
}
