package com.atguigu.javaweb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "TokenServlet",
        urlPatterns = "/token/tokenServlet")
public class TokenServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        HttpSession session = request.getSession();
        Object token = session.getAttribute("token");
        String tokenValue = request.getParameter("token");

        System.out.println(token);
        System.out.println(tokenValue);


        if (token != null && token.equals(tokenValue)) {
            session.removeAttribute("token");
        } else {
            response.sendRedirect(request.getContextPath() + "/token/token.jsp");
            return;
        }

        String name = request.getParameter("name");
        System.out.println("name:" + name);

//        request.getRequestDispatcher("/token/success.jsp").forward(request,response);

        response.sendRedirect(request.getContextPath() + "/token/success.jsp");
    }


}
