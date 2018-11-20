package com.atguigu.javaweb;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class SecondFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("second init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        System.out.println("3:Before SecondFilter's filterChain.doFilter...");//3

        //放行
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("4:After SecondFilter's filterChain.doFilter...");//4
    }

    @Override
    public void destroy() {
        System.out.println("destroy...");
    }
}
