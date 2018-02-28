package com.yanjinbin;

import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RestController
public class ExceptionHandleDemoController {

    @Autowired
    private HelloService helloService;


    @RequestMapping("/npe")
    public void throwNPE() {
        helloService.throwNPE(null);
    }

    @RequestMapping("/catch_npe")
    public void catchNPE(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // try {

        show();
        helloService.throwNPE(null);
        //} catch (Exception e) {
        // log.error("异常堆栈信息----- {}", e.getMessage());
        // e.printStackTrace();
        //    response.getWriter().write(e.getMessage());
        //  }
    }

    public String show() throws NullPointerException {
        String a = null;
        Preconditions.checkNotNull(a);
        System.out.println(a.toCharArray());
        return "hhaaa";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Response get() {
        Student jiangzhuxi = Student.builder().age(11).name("jiangzhuxi").build();
        return Response.createSuccess(jiangzhuxi, "哈哈");
    }

    @RequestMapping(value = "/put", method = RequestMethod.PUT)
    public Response put(@RequestBody Student student) {
        return Response.createSuccess(student, "更新成功");
    }


    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public Response create(@RequestBody Student student) {

        return Response.createSuccess(student, "创建成功");
    }

    @RequestMapping(value = "/direct_npe", method = RequestMethod.GET)
    public Response directThrow(@RequestParam(defaultValue = "1") Integer age) {
        if (age < 10) {
            throw new NullPointerException("哈哈哈哈NPE");
        }
        return Response.createSuccess();
    }

}
