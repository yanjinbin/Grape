package com.yanjinbin.springboot.hellomodule;

import com.yanjinbin.springboot.Util.ViewResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Silver Bullet
 * @since 三月-03
 */
@RestController
@RequestMapping(value = "/user/")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value = "update", method = RequestMethod.PUT)
    private ViewResult update(@ModelAttribute User user) {
        userRepository.update(user);
        return ViewResult.createSuccess();
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    private ViewResult<User> get(@PathVariable Integer id) {
        User user = userRepository.get(id);
        if (user != null) {
            return ViewResult.createSuccess();
        }
        return ViewResult.createFail("获取失败");
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    private ViewResult delete(Integer userId) {
        userRepository.detele(userId);
        return ViewResult.createSuccess();
    }
}
