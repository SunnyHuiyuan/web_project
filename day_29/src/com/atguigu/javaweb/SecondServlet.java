package com.atguigu.javaweb;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondServlet implements Servlet {

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
        System.out.println("second Servlet init...");
    }

    @Override
    public void service(ServletRequest arg0, ServletResponse arg1) {
        // TODO Auto-generated method stub
        System.out.println("second service");
    }


}
