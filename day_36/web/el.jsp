<%@ page import="com.atguigu.javaweb.Customer" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: LK
  Date: 2018/9/1
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="el.jsp" method="post">
        username:<input type="text" name="username" value=
            "<%=request.getParameter("username")==null?"":request.getParameter("username")%>">
        <input type="submit" value="提交">

        username:<input type="text" name="username" value="${param.username}">
        <input type="submit" value="提交">
    </form>

    username:<%=request.getParameter("username")%>

    <br><br>
    
    <jsp:useBean id="customer" class="com.atguigu.javaweb.Customer" scope="session"></jsp:useBean>
    <jsp:setProperty name="customer" property="age" value="12"></jsp:setProperty>

    age:
    <%
        Customer customer1=(Customer) session.getAttribute("customer");
        out.print(customer1.getAge());
    %>

    <br><br>

    age:<jsp:getProperty name="customer" property="age"></jsp:getProperty>

    <br><br>

    <%
        application.setAttribute("time",new Date());
    %>

    <a href="el2.jsp?score=89&name=A&name=B&name=C">To El2.jsp</a>

</body>
</html>













