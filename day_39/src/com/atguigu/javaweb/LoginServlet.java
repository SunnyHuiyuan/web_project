package com.atguigu.javaweb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String methodName = request.getParameter("method");

        try {
            Method method = getClass().getMethod(methodName,
                    HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private UserDao userDao = new UserDao();

    public void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //1.获取name
        String name = request.getParameter("name");

        //2.调用UserDao获取用户信息，把用户信息放入到HttpSession中
        User user = userDao.get(name);
        request.getSession().setAttribute("user", user);

        //3.重定向articles.jsp
        response.sendRedirect(request.getContextPath() + "/articles.jsp");
    }

    public void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //1.获取session
        //2.使HttpSession失效
        request.getSession().invalidate();

        //3.重定向到/login.jsp
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
}
