import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author Grape
 * @Since 2017/8/10.
 */
public class VirginStreamTry {
    public static void main(String[] args) {

    }

    public  void runTask(){
        new Thread(new Runnable() {
            public void run() {
                System.out.println("running a task");
            }
        }).start();
    }

    public void runThreadUseLambda() {
            new Thread(()->{
                System.out.println("running a task by lambda way");
            }).start();
    }

    public void sortLambda(){
        List<Integer> list = new ArrayList<Integer>();
        Collections.sort(list,(x,y)-> {return y-x;});
    }

//    class Animal<Integer> implements Comparator{
//
//
//        @Override
//        public int compare(Object o1, Object o2) {
//            return 0;
//        }
//    }
}
