package springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Silver Bullet
 * @since 三月-03
 */
@RestController
public class HelloWorldController {

    @RequestMapping(value = "/hello")
    public ViewResult hello(String a) {
        return ViewResult.createSuccess(a, "你大爷");
    }
}
