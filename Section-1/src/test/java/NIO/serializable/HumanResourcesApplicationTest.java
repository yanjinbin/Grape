package NIO.serializable;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author Silver Bullet
 * @since 一月-10
 */
public class HumanResourcesApplicationTest {

    private HumanResourcesApplication classUnderTest;

    private List<Employee> testData;

    @Before
    public void setUp() throws Exception {
        classUnderTest = new HumanResourcesApplication();
        testData = HumanResourcesApplication.createEmloyees();
    }


    @Test
    public void testSerialize2Disk() throws Exception {
        String filename = "employees-Junit-" + System.currentTimeMillis() + ".ser";
        boolean status = classUnderTest.serialize2Disk(filename, testData);
        Assert.assertTrue(status);
    }
}