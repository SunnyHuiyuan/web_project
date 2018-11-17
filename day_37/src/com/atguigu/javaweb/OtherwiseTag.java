package com.atguigu.javaweb;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class OtherwiseTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        ChooseTag chooseTag = (ChooseTag) getParent();

        if(chooseTag.isFlag()){
            getJspBody().invoke(null);
        }
    }
}
