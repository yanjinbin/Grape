public class Test {
    public static void main(String[] args) {
        test1();
        System.out.println("======");
        test2();
        System.out.println("=======");
        test3();
        System.out.println("=======");
        test4();
    }

    public static void test1() {

        brief:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if (j >= 4) break brief;
                System.out.println("i:" + i + "j:" + j);
            }
        }
        System.out.println("哈哈");
    }

    public static void test2() {

        brief:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if (j >= 4) break;
                System.out.println("i:" + i + "j:" + j);
            }
        }
        System.out.println("哈哈");
    }

    public static void test3() {

        brief:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if (j >= 4) continue brief;
                System.out.println("i:" + i + "j:" + j);
            }
        }
        System.out.println("哈哈");
    }

    public static void test4() {

        brief:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if (j >= 4) continue;
                System.out.println("i:" + i + "j:" + j);
            }
        }
        System.out.println("哈哈");
    }
}
