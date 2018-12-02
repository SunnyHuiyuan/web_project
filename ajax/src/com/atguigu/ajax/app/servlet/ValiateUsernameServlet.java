package com.atguigu.ajax.app.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "ValiateUsernameServlet", urlPatterns = {"/valiateUsername"})
public class ValiateUsernameServlet extends HttpServlet {
    private static final long serialVersionUID = -1101046261166246411L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> userNames = Arrays.asList("AAA", "BBB", "CCC", "DDD", "EEE");

        String username = request.getParameter("username");
        String result = null;
        if (userNames.contains(username)) {
            result = "<font color='red'>该用户名已被注册<font>";
        } else {
            result = "<font color='green'>该用户名可以注册<font>";
        }

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(result);
    }

}
