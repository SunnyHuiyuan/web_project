<%@ page import="com.atguigu.javaweb.Customer" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="el.jsp" method="post">
    username:<input type="text" name="username"
                    value="<%=request.getParameter("username")==null?"":request.getParameter("username")%>">

    username:<input type="text" name="username"
                    value="${param.username}">

    <input type="submit" value="submit">
</form>
username:<%=request.getParameter("username")%>

<br><br>

<jsp:useBean id="customer" class="com.atguigu.javaweb.Customer" scope="session"></jsp:useBean>
<jsp:setProperty name="customer" property="age" value="12"></jsp:setProperty>

<%
application.setAttribute("time",new Date());
%>
age:
<%
    Customer customer1 = (Customer) session.getAttribute("customer");
    out.print(customer1.getAge());
%>

<br>

age:
<jsp:getProperty name="customer" property="age"></jsp:getProperty>

<br>

<a href="el2.jsp?score=89&name=A&name=B&name=C">to el2 page</a>

</body>
</html>
