package CommonUtil;

/**
 * @author Silver Bullet
 * @since 三月-10
 */
public class IFELSETry {
    public static void main(String[] args) {
        System.out.println(trick(11, 1));


    }

    public static Boolean trick(Integer i, Integer j) {
        if (i == 10 && j == 1) {
            return false;
        }
        /* else */
        return i == 10 && j != 1;

    }
}
