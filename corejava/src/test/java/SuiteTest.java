import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;

import java.util.Iterator;
import java.util.List;

/**
 * @author Silver & Bullet
 *         on 二月-18
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(value = {
        MiscTest.class,BaseTest.class,JunitTryTest.class
})
public class SuiteTest {

    //套件测试
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(SuiteTest.class);
        List<Failure> failures = result.getFailures();
        Iterator<Failure> iterator = failures.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().getDescription());
        }
    }
}
