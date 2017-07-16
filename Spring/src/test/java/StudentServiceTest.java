import com.yanjinbin.spring.BaseApplication;
import com.yanjinbin.spring.Student;
import com.yanjinbin.spring.StudentMapper;
import com.yanjinbin.spring.StudentService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * @Author Grape
 * @Since 2017/7/7.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BaseApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentMapper studentMapper;

    @Before
    public void setUp() {
        // 准备，清空user表
        studentService.deleteAllUsers();
    }

    @Test
    public void test() throws Exception {
        // 插入5个用户
        studentService.create("a", 1);
        studentService.create("b", 2);
        studentService.create("c", 3);
        studentService.create("d", 4);
        studentService.create("e", 5);
        // 查数据库，应该有5个用户
        Assert.assertEquals(5, studentService.getAllUsers().intValue());
        // 删除两个用户
        studentService.deleteByName("a");
        studentService.deleteByName("e");
        // 查数据库，应该有5个用户
        Assert.assertEquals(3, studentService.getAllUsers().intValue());
    }

    @Test
    public void findByName() throws Exception {
        LocalDateTime ldt = LocalDateTime.now();
        Date now = Date.from(ldt.toInstant(ZoneOffset.UTC));
//        studentMapper.insert("AAA", 20, now, now);
        studentMapper.insert("BBB",21,null,null);
        Student u = studentMapper.findByName("AAA");
        Assert.assertEquals(20, u.getAge());
        studentMapper.deleteByName("AAA");
    }

}

