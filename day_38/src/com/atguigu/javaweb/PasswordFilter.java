package com.atguigu.javaweb;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class PasswordFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String initPassword = filterConfig.getServletContext().getInitParameter("password");
        String password = request.getParameter("password");

        if (!initPassword.equals(password)) {
            request.setAttribute("message", "密码不正确");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        chain.doFilter(request, response);
    }

    private FilterConfig filterConfig;

    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = config;
    }

}
