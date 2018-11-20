package com.atguigu.javaweb;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class HelloFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("1:Before HelloFilter's filterChain.doFilter...");//1

        //放行
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("2:After HelloFilter's filterChain.doFilter...");//2
    }

    @Override
    public void destroy() {
        System.out.println("destroy...");
    }
}
