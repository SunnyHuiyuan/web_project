package com.atguigu.javaweb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ProcessStep2Servlet", urlPatterns = "/shoppingcart/processStep2")
public class ProcessStep2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //处理请求的中文乱码
        request.setCharacterEncoding("UTF-8");

        //1. 获取请求参数: name, address, cardType, card
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String cardType = request.getParameter("cardType");
        String card = request.getParameter("card");

        Customer customer = new Customer(name, address, cardType, card);

        //2. 把请求信息存入到 HttpSession 中
        HttpSession session = request.getSession();
        session.setAttribute("customer",customer);

        //3. 重定向页面到 confirm.jsp
        response.sendRedirect(request.getContextPath()+"/shoppingcart/confirm.jsp");

    }


}

