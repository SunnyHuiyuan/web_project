package com.atguigu.javaweb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CheckCodeServlet",
        urlPatterns = "/check/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //1.获取请求参数:CHECK_CODE_PARAM_NAME
        String parmCode = request.getParameter("CHECK_CODE_PARAM_NAME");

        //2.获取session中CHECK_CODE_KEY的属性值
        HttpSession session = request.getSession();
        String sessionCode = (String) session.getAttribute("CHECK_CODE_KEY");

        //打印
        System.out.println(parmCode);
        System.out.println(sessionCode);

        //3.比对，看是否一致：若一致则说明验证码正确，不一致则说明验证码错误
        if (!(parmCode!=null&&parmCode.equals(sessionCode))){
            request.getSession().setAttribute("message","验证码不一致！");
            response.sendRedirect(request.getContextPath()+"/check/index.jsp");
            return;
        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out=response.getWriter();
        out.print("请求成功！");


    }


}
