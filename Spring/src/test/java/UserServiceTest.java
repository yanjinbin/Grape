import com.yanjinbin.spring.BaseApplication;
import com.yanjinbin.spring.Student;
import com.yanjinbin.spring.StudentMapper;
import com.yanjinbin.spring.StudentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author Grape
 * @Since 2017/7/7.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BaseApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentMapper studentMapper;

    @org.junit.Before
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
    @Rollback
    public void findByName() throws Exception {
        studentMapper.insert("AAA", 20);
        Student u = studentMapper.findByName("AAA");
        Assert.assertEquals(20, u.getAge());
    }

}

