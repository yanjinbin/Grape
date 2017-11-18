package com.yanjinbin.springboot;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Silver Bullet
 * @since 三月-10
 */
public class GeneralInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String age = request.getHeader("age");
        String clickTime = request.getParameter("clickTime");
        if (!StringUtils.isEmpty(clickTime)) {
            request.setAttribute("unversity", "浙大");
        }
        return true;
    }
}
