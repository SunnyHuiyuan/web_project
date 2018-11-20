package com.atguigu.javaweb.cache;

import com.atguigu.javaweb.HttpFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Filter典型应用之一：
 * 使浏览器不缓存页面的过滤器
 */
@WebFilter(filterName = "NoCacheFilter", urlPatterns = "/cache/*")
public class NoCacheFilter extends HttpFilter {

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("cacheFilter's doFilter..");

        response.setDateHeader("Expires", -1);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        filterChain.doFilter(request, response);
    }
}
