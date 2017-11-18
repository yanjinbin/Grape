package CommonUtil;

import java.util.UUID;

/**
 * @author Silver Bullet
 * @since 十二月-22
 */
public class UUIDUtil {

    private String uuid(){
        String replace = UUID.randomUUID().toString().replace("-", "");
        return replace;
    }
}
