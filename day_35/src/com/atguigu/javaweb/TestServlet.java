package com.atguigu.javaweb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "TestServlet",urlPatterns = "/testServlet")
public class TestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<String> citys= Arrays.asList("北京","上海","重庆");

        request.setAttribute("citys",citys);

        //转发到b.jsp
        request.getRequestDispatcher("/path/b.jsp").forward(request,response);

//        response.sendRedirect(request.getContextPath()+"/path/c.jsp");

    }
}
