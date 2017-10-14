import com.yanjinbin.springboot.hellomodule.UserController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author Silver Bullet
 * @since 三月-03
 */
public class UserControllerTest extends BaseTest {
    @Before
    public void setup() {
        MockMvcBuilders.standaloneSetup(new UserController());
    }


    @Test
    public void testUserController() throws Exception {
        RequestBuilder requestBuilder = null;

    }
}
