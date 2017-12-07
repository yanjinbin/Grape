package com.yanjinbin.interceptor;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Silver Bullet
 * @since 三月-13
 */
public class TestFilter2 extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        System.out.println("############TestFilter2 doFilterInternal executed############");
        String a=null;
//        System.out.println(a.toCharArray());
        filterChain.doFilter(request, response);
        System.out.println("############TestFilter2 doFilter after############");

    }

}