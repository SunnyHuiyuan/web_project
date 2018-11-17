package com.atguigu.javaweb;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

public class TestJspFragment extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        JspFragment bodyContent = getJspBody();
        /*
        JspFragment.invoke(writer):writer 即为标签体内容输出的字符流，若为null,则输出到
        getJspContext.getOut()，即输出到页面上。
         */
        //1.利用StringWriter 得到标签体的内容
        StringWriter sw = new StringWriter();
        bodyContent.invoke(sw);

        //2，把标签体的内容都变为大写
        String content = sw.toString().toUpperCase();

        //3.获取jsp页面的out隐含对象，输出到页面上
        getJspContext().getOut().print(content);
    }
}
