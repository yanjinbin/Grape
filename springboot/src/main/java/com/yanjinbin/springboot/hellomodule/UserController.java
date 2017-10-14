package com.yanjinbin.springboot.hellomodule;

import com.alibaba.fastjson.JSON;
import com.yanjinbin.springboot.Util.ViewResult;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
    private ViewResult<User> get(@PathVariable Integer id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Enumeration<String> headerNames = request.getHeaderNames();
        System.out.println("HeaderNames   " + JSON.toJSONString(headerNames));
        Enumeration<String> parameterNames = request.getParameterNames();
        System.out.println("ParameterNames    "+JSON.toJSONString(parameterNames));
        System.out.println("localPort    " + request.getLocalPort());
        System.out.println("contentType    " + request.getContentType());
        System.out.println("AuthType   " + request.getAuthType());
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        Iterator<Map.Entry<String, String[]>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        int i = 0;
        Enumeration<String> attributeNames = request.getAttributeNames();
        if (attributeNames.hasMoreElements()) {
            System.out.println((i++) + "    " + attributeNames.nextElement());
        }
        User user = userRepository.get(id);

        response.setStatus(HttpStatus.OK.value());
        response.setHeader("coke","可口可乐");
        response.setContentType(ContentType.APPLICATION_JSON.toString());
        response.sendRedirect("localhost:8080/hello/world");


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
