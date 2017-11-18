import junit.framework.TestCase;
import org.junit.Before;

/**
 * @author Silver & Bullet
 *         on 二月-18
 */
public class TestJunit2 extends TestCase {

    protected double f1;

    protected double f2;

    @Before
    public void setUp() {
        f1 = 2;
        f2 = 3;
    }

    @org.junit.Test
    public void testAdd() {
        //count the number of test cases
        System.out.println("No of Test Case = " + this.countTestCases());

        //test getName
        String name = this.getName();
        System.out.println("Test Case Name = " + name);

        //test setName
        this.setName("testNewAdd");
        String newName = this.getName();
        System.out.println("Updated Test Case Name = " + newName);

    }
}
