import org.junit.Assert;
import org.junit.Ignore;

/**
 * @author Silver & Bullet
 *         on 二月-18
 */

public class JunitTryTest {

    //异ོ常ོ测ོ试ོ
    @org.junit.Test(expected = ArithmeticException.class)
    public void exceptionTest() {
        System.out.println("哈ོ哈ོ哈ོ");
        int i = 1 / 0;
        System.out.println("嘿ོ嘿ོ");
    }


    //运行时间测试
    @org.junit.Test(timeout = 10)
    public void timeoutTest() throws InterruptedException {
        Thread.sleep(100L);
        System.out.println("时间测试");

    }
    @Ignore
    @org.junit.Test
    public void ignoreTest(){
        System.out.println("-----以下文字说明该测试并没有被忽略----");
        System.out.println("=====忽略测试正在生成===");
    }


    @org.junit.Test
    public void assertTest(){
      //  Assert.assertNull(null);
        Assert.assertFalse(false);
        Assert.assertNotNull(null);
    }




    //以下为未学习部分  1 参数化测试  2 其他测试框架 3 chapter 5  重要的 API 学习

    //参数化测试  todo

    //其他测试框架

    //MOCKobject  junitweb xmlunit cactus



}
