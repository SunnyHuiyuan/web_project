package com.atguigu.javaweb.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TestServlet", urlPatterns = "/testServlet")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("requestKey", "requestValue2");

        //1.请求的转发是一个请求，request可以获得到值
        request.getRequestDispatcher("/test.jsp").forward(request, response);

        //2.请求的重定向是两个请求，无法获得请求域中的值
//        response.sendRedirect("test.jsp");
    }
}
