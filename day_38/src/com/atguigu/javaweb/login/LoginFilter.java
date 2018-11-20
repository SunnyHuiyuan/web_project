package com.atguigu.javaweb.login;

import com.atguigu.javaweb.HttpFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Filter典型应用之三：检测用户是否登陆的过滤器
 */
@WebFilter(filterName = "LoginFilter", urlPatterns = "/login/*")
public class LoginFilter extends HttpFilter {

    //1.从 web.xml 文件中获取 sessionKey,redirectUrl,uncheckedUrls
    private String sessionKey;
    private String redirectUrl;
    private String uncheckedUrls;

    @Override
    protected void init() {
        ServletContext servletContext = getFilterConfig().getServletContext();

        sessionKey = servletContext.getInitParameter("userSessionKey");
        redirectUrl = servletContext.getInitParameter("redirectPage");
        //uncheckedUrls获取到的值：/login/login.jsp,/login/list.jsp,/login/a.jsp,/login/doLogin.jsp
        uncheckedUrls = servletContext.getInitParameter("uncheckedUrls");
    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        //1.获取请求的servletPath
        String servletPath = request.getServletPath();// /login/list.jsp

        //2.检查 1 获取的 servletPath 是否为不需要检查的 URL 中的一个，若是，则直接放行。方法结束
        List<String> urls = Arrays.asList(uncheckedUrls.split(","));
        if (urls.contains(servletPath)) {
            filterChain.doFilter(request, response);
            return;
        }

        //3.从 session 中获取 sessionKey 对应的值，若值不存在，则重定向到redirectUrl
        Object user=request.getSession().getAttribute(sessionKey);
        if(user==null){
            response.sendRedirect(request.getContextPath()+redirectUrl);
            return;
        }

        //4.若存在，则放行，允许访问。
        filterChain.doFilter(request,response);
    }
}
