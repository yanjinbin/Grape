import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author Silver Bullet
 * @since 三月-03
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BaseApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseTest {

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup(){
        System.out.println("");
        String nobug="" +
                "//                            _ooOoo_    \n" +
                "//                           o8888888o    \n" +
                "//                           88\" . \"88    \n" +
                "//                           (| -_- |)    \n" +
                "//                            O\\ = /O    \n" +
                "//                        ____/`---'\\____    \n" +
                "//                      .   ' \\\\| |// `.    \n" +
                "//                       / \\\\||| : |||// \\    \n" +
                "//                     / _||||| -:- |||||- \\    \n" +
                "//                       | | \\\\\\ - /// | |    \n" +
                "//                     | \\_| ''\\---/'' | |    \n" +
                "//                      \\ .-\\__ `-` ___/-. /    \n" +
                "//                   ___`. .' /--.--\\ `. . __    \n" +
                "//                .\"\" '< `.___\\_<|>_/___.' >'\"\".    \n" +
                "//               | | : `- \\`.;`\\ _ /`;.`/ - ` : | |    \n" +
                "//                 \\ \\ `-. \\_ __\\ /__ _/ .-` / /    \n" +
                "//         ======`-.____`-.___\\_____/___.-`____.-'======    \n" +
                "//                            `=---='    \n" +
                "//    \n" +
                "//         .............................................    \n" +
                "//                  佛祖镇楼               永无bug    \n" +
                "//          佛曰:    \n" +
                "//                  写字楼里写字间，写字间里程序员；    \n" +
                "//                  程序人员写程序，又拿程序换酒钱。    \n" +
                "//                  但愿老死电脑间，不愿鞠躬老板前；    \n" +
                "//                  奔驰宝马贵者趣，公交自行程序员。    \n" +
                "//                  别人笑我忒疯癫，我笑自己命太贱；    \n" +
                "//                  不见满街漂亮妹，哪个归得搬砖工?    \n" +
                "\n";
        System.out.println(nobug);
        System.out.println("-------set up build ----------");






    }
}
