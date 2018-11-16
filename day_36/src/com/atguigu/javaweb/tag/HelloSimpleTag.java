package com.atguigu.javaweb.tag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;
import java.io.IOException;

public class HelloSimpleTag implements SimpleTag {
    private String value;
    private String count;

    public void setValue(String value) {
        this.value = value;
    }

    public void setCount(String count) {
        this.count = count;
    }

    /**
     * 标签体逻辑实际应该编写到该方法中
     *
     * @throws JspException
     * @throws IOException
     */
    @Override
    public void doTag() throws JspException, IOException {
       /* System.out.println("value:"+value+"---count:"+count);

        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        pageContext.getOut().print("Hello:" + request.getParameter("name"));*/

        JspWriter out = pageContext.getOut();
        int c = 0;
        c = Integer.parseInt(count);
        for (int i = 0; i < c; i++) {
            out.print((i+1)+":"+value);
            out.print("<br>");
        }
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

    private PageContext pageContext;

    /**
     * jsp 引擎调用，把代表 jsp页面的 PageContext 对象传入
     * PageContext 可以获取 JSP 页面的其他八个隐含对象
     * 所以凡是 JSP 页面可以做的标签处理器都可以完成
     *
     * @param jspContext
     */
    @Override
    public void setJspContext(JspContext jspContext) {
        System.out.println(jspContext instanceof PageContext);
        this.pageContext = (PageContext) jspContext;
    }

    @Override
    public void setJspBody(JspFragment jspFragment) {
        System.out.println("setJspBody");
    }
}
