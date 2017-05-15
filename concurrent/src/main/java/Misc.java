/**
 * @Author Silver bullet
 * @Since 2017/5/12.
 */
public class Misc {
    public static void main(String[] args) {
        if (true && false) {
            System.out.println("哈哈哈");
        }
        int arg = 1;
        if (!tryAcquire(arg) && acquireQueue(arg)) {
            System.out.println("success !!");
        }
    }


    public static boolean tryAcquire(int arg) {
        if (arg > 10) return true;
        else return false;
    }

    public static boolean acquireQueue(int arg) {
        if (arg < 15 && tryAcquire(arg)) {
            arg++;
            if (arg > 10) {
                return tryAcquire(arg);
            }
        }
        return false;
    }
}
