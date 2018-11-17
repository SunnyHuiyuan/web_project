package com.atguigu.javaweb;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class ParentTag extends SimpleTagSupport {

    private String name = "WWW.ATGUIGU.COM";

    public String getName() {
        return name;
    }

    @Override
    public void doTag() throws JspException, IOException {
        System.out.println("父标签的标签处理器类 name:"+name);
        getJspBody().invoke(null);
    }
}
