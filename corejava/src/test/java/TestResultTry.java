import junit.framework.AssertionFailedError;
import junit.framework.TestResult;

/**
 * @author Silver & Bullet
 *         on 二月-18
 */
public class TestResultTry extends TestResult {

    public synchronized void addError(Test test, Throwable t) {
        super.addError((junit.framework.Test) test, t);
    }

    // add the failure
    public synchronized void addFailure(Test test, AssertionFailedError t) {
        super.addFailure((junit.framework.Test) test, t);
    }

    @org.junit.Test
    public void testAdd() { // add any test
    }
    // Marks that the test run should stop. public synchronized void stop() { //stop the test here

}
