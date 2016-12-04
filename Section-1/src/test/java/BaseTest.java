import org.junit.Before;

import java.util.Date;

/**
 * Created by Silver & Bullet
 * since 2016-十二月
 */
public class BaseTest {
    @Before
    public void junitBefore(){
        System.out.println("junit单元测试开始----测试日期---"+new Date());
    }
}
