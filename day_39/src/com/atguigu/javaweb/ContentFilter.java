package com.atguigu.javaweb;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * HttpServletRequestWrapper:实现不雅字符的过滤
 */
@WebFilter(filterName = "ContentFilter", urlPatterns = "/bbs.jsp")
public class ContentFilter extends HttpFilter {

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        //1.获取请求参数content参数的值
        String content = request.getParameter("content");

        System.out.println(request);
        HttpServletRequest req = new MyHttpServletRequest(request);

        //2.把其中fuck,shit等字符串替换为*****
        if (content.contains(" fuck ")) {
            //ServletRequest,HttpServletRequest中并没有提供诸如setParameter(paramName,paramValue)
            //类似于这样的方法

            //目标：改变HttpServletRequest的getParameter(String)方法的行为：若该方法的返回值中包含
            //" fuck ",则替换为"****",

            //1.若对于一个类的方法不满意，需要进行重写，最常见的方式是继承父类，重写方法
            //若实现则需要继承org.apache.catalina.connector.RequestFacade@52670bb6，而这仅是Tomcat
            //副武器的实现，若更换服务器，该方案将无法使用。此方案不可行

            //2.直接写一个HttpServletRequest接口的实现类：无法实现其中的方法。此方案不可行

            //3.装饰目前的HtpServletRequest对象：装饰其getParameter()方法，而其他方法还和其实现相同。
            //创建一个类，该类实现HtpServletRequest接口，把当前doFilter中的request传入到该类中，作为
            //其成员变量，使用该成员变量去实现接口的全部方法。
        }

        //3.转到目标界面
        filterChain.doFilter(req, response);

    }
}
