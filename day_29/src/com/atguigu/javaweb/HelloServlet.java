package com.atguigu.javaweb;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class HelloServlet implements Servlet {

    @Override
    public void destroy() {
        System.out.println("destroy");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig");
        return null;
    }

    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo");
        return null;
    }

    @Override
    public void init(ServletConfig servletConfig) {
        System.out.println("init");

//        1).getInitParameter(String name): 获取指定参数名的初始化参数
        String user = servletConfig.getInitParameter("user");
        System.out.println("user： " + user);

//        2).getInitParameterNames(): 获取参数名组成的 Enumeration 对象.
        Enumeration<String> names = servletConfig.getInitParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String value = servletConfig.getInitParameter(name);
            System.out.println("^^" + name + ": " + value);
        }

//        3).获取 Serlvet 的配置名称(了解)
        String serlvetName = servletConfig.getServletName();
        System.out.println(serlvetName);


//        1).获取 ServletContext 对象
        ServletContext servletContext = servletConfig.getServletContext();

//        ①. getInitParameter 和 getInitParameterNames
        String driver = servletContext.getInitParameter("driver");
        System.out.println("driver:" + driver);

        Enumeration<String> names2 = servletContext.getInitParameterNames();
        while (names2.hasMoreElements()) {
            String name = names2.nextElement();
            System.out.println("-->" + name);
        }

//        ②. 获取当前 WEB 应用的某一个文件在服务器上的绝对路径, 而不是部署前的路径
        String realPath = servletContext.getRealPath("/note.txt");
        //不是: E:\Java\Source\atguigu\java-1\day_29\WebContent\note.txt
        System.out.println(realPath);

//         ③. 获取当前 WEB 应用的名称:
        String contextPath = servletContext.getContextPath();
        System.out.println(contextPath);

//         ④. 获取当前 WEB 应用的某一个文件对应的输入流.
        Properties pros = new Properties();

        try {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream is = classLoader.getResourceAsStream("jdbc.properties");
            System.out.println("1. " + is);
            pros.load(is);

            System.out.println(pros.getProperty("name"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        pros = new Properties();

        try {
            InputStream is2 = servletContext.getResourceAsStream("/WEB-INF/classes/jdbc.properties");
            System.out.println("2. " + is2);
            pros.load(is2);
            System.out.println(pros.getProperty("name"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        String picPath = servletContext.getRealPath("/WEB-INF/lib");
        System.out.println(picPath);
    }

    @Override
    public void service(ServletRequest arg0, ServletResponse arg1) {
        System.out.println("service");
    }


//    构造器
    public HelloServlet() {
        System.out.println("HelloServlet's constructor");
    }

}
