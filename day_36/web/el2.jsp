<%@ page import="com.atguigu.javaweb.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: LK
  Date: 2018/9/1
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el2.jsp</title>
</head>
<body>

    <!--
        如果域对象中的属性名带有特殊字符, 则使用 [] 运算符会很方便.
    -->
    name:${sessionScope["con.atguigu.customer"].name}


    <!-- 1. EL 的 . 或 [] 运算符 -->
    <%
        Customer customer=new Customer();
        customer.setName("atguigu");

        session.setAttribute("con.atguigu.customer",customer);
    %>
    <br>


    <!-- 2. EL 中的隐含对象 -->
    <%
        Customer customer2=new Customer();
        customer2.setAge(28);
        request.setAttribute("customer",customer2);

    %>
    age:${customer.age}
    <br>
    age:${sessionScope.customer["age"]}
    <br>

    <%--<%
        Customer customer=(Customer) session.getAttribute("customer");
        out.print(customer.getAge());
    %>--%>


    <!-- 3. EL 可以进行自动的类型转换 -->
    score:${param.score+11}
    <br>
    score:<%=request.getParameter("score")+11%>
    <br>


    <!-- 4. 隐含对象之与范围相关的: pageScope, requestScope, sessionScope, applicationScope -->
    time:${time}
    <%--相当于下面代码：
        <%=application.getAttribute("time")%>
    --%>
    <br>


    <!-- 5. 与输入有关的隐含对象: param, paramValues -->
    score: ${param.score }
    <%--
    <%= request.getParameter("score") %>
    --%>
    <br>
    names: ${paramValues.name[0]}
    <%--
    <%=
        request.getParameterValues("name")[0].getClass().getName()
    %>
    --%>
    <br>


    <!-- 6. 其他隐含对象: pageContext 等(cookie, header, initParam 只需了解.) -->
    JSESSIONID:${cookie.JSESSIONID.name}---${cookie.JSESSIONID.value}
    <br>
    Accept-Language:${header["Accept-Language"]}
    <br>

   <%-- pageContext: pageContext 即为 PageContext 类型, 但只能读取属性就可以一直的 . 下去。--%>
    <br>
    contextPath: ${pageContext.request.contextPath }

    <br>
    sessionId: ${pageContext.session.id }

    <br>
    sessionAttributeNames: ${pageContext.session.attributeNames }

    <br>


    <!-- 7. EL 的运算符 -->
    ${param.score > 60 ? "及格" : "不及格" }
    <br>

    <%
        List<String> names = new ArrayList<String>();
        names.add("abc");
        request.setAttribute("names", names);
    %>
    <!-- empty 可以作用于一个集合, 若该集合不存在或集合中没有元素, 其结果都为 true -->
    names is empty: ${empty requestScope.names }
    <br>




</body>
</html>
