package com.atguigu.javaweb;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

@WebServlet(name = "loginServlet",
        urlPatterns = "/loginServlet")
public class LoginServlet implements Servlet {

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public ServletConfig getServletConfig() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getServletInfo() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void init(ServletConfig arg0) {
        // TODO Auto-generated method stub

    }


    @Override
    public void service(ServletRequest request, ServletResponse response)
            throws IOException {
        System.out.println("请求来了...");
        System.out.println(request);

//         > String getParameter(String name): 根据请求参数的名字, 返回参数值.
        String user = request.getParameter("user");
        String password = request.getParameter("password");

        System.out.println(user + ", " + password);

        String interesting = request.getParameter("interesting");
        System.out.println(interesting);

//         > String[] getParameterValues(String name): 根据请求参数的名字, 返回请求参数对应的字符串数组.
        String[] interestings = request.getParameterValues("interesting");
        for (String interest : interestings) {
            System.out.println("-->" + interest);
        }

//         > Enumeration getParameterNames(): 返回参数名对应的 Enumeration 对象,
//        类似于 ServletConfig(或 ServletContext) 的 getInitParameterNames() 方法.
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String val = request.getParameter(name);

            System.out.println("^^" + name + ": " + val);
        }

//         > Map getParameterMap(): 返回请求参数的键值对: key: 参数名,  value: 参数值, String 数组类型.
        Map<String, String[]> map = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            System.out.println("**" + entry.getKey() + ":" + Arrays.asList(entry.getValue()));
        }

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

//        获取请求的 URI:
        String requestURI = httpServletRequest.getRequestURI();
        System.out.println(requestURI);

//        获取请求方式:
        String method = httpServletRequest.getMethod();
        System.out.println(method);

//        若是一个 GET 请求, 获取请求参数对应的那个字符串, 即 ? 后的那个字符串.
        String queryString = httpServletRequest.getQueryString();
        System.out.println(queryString);

//        获取请求的 Serlvet 的映射路径
        String servletPath = httpServletRequest.getServletPath();
        System.out.println(servletPath);


        response.setContentType("application/msword");

        PrintWriter out = response.getWriter();
        out.println("helloworld...");

    }


}
