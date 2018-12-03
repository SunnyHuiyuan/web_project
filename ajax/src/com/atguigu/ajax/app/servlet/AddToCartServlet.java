package com.atguigu.ajax.app.servlet;

import com.atguigu.ajax.app.beans.ShoppingCart;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AddToCartServlet", urlPatterns = {"/app2/addToCart"})
public class AddToCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //1.获取请求参数：id,price
        String bookname = request.getParameter("id");
        int price = Integer.parseInt(request.getParameter("price"));

        //2.获取购物车对象
        HttpSession session = request.getSession();
        ShoppingCart sc = (ShoppingCart) session.getAttribute("sc");

        if (sc == null) {
            sc = new ShoppingCart();
            session.setAttribute("sc", sc);
        }

        //3.把点击的对象加入到购物车
        sc.addToCart(bookname, price);

        //4.准备  响应的json对象
        //若从服务端返回json对象，则属性名必须使用双引号
       /* StringBuilder result = new StringBuilder();
        result.append("{")
                .append("\"bookname\":\"" + bookname+"\"")
                .append(",")
                .append("\"totleBookNumber\":" + sc.getTotleBookNumber())
                .append(",")
                .append("\"totleMoney\":" + sc.getTotleMoney())
                .append("}");*/

        //使用jackson来将一个对象返回json数据类型
       /* ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(sc);
        System.out.println(result);

        //5.响应json对象
        response.setContentType("text/javascript");
//        response.getWriter().print(result.toString());
        //调用mapper的writeValueAsString()方法把一个对象转为json字符串
        response.getWriter().print(result);*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
