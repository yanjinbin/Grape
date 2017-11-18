import com.yanjinbin.springboot.PropertyValue.PropertiesValue;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Silver Bullet
 * @since 三月-03
 */
public class PropertyTest extends BaseTest{

    @Autowired
    private PropertiesValue propertiesValue;

    @Test
    public void propertyValue(){
        String name = propertiesValue.getName();
        System.out.println(name);
    }
}
