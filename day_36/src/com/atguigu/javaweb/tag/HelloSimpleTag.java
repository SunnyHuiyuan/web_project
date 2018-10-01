package com.atguigu.javaweb.tag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;
import java.io.IOException;

public class HelloSimpleTag implements SimpleTag {
    @Override
    public void doTag() throws JspException, IOException {
        System.out.println("doTag");
    }

    @Override
    public void setParent(JspTag jspTag) {
        System.out.println("setParent");
    }

    @Override
    public JspTag getParent() {
        System.out.println("getParent");
        return null;
    }

    @Override
    public void setJspContext(JspContext jspContext) {
        System.out.println("setJspContext");
    }

    @Override
    public void setJspBody(JspFragment jspFragment) {
        System.out.println("setJspBody");
    }
}
