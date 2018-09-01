<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: LK
  Date: 2018/8/31
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>表单的重复提交</title>
</head>
<body>
    <%
        String tokenValue=new Date().getTime()+"";
        session.setAttribute("token",tokenValue);
    %>

    <form action="tokenServlet" method="post">
        <input type="hidden" name="token" value="<%=tokenValue%>">
        name:<input type="text" name="name">
        <input type="submit" value="提交">
    </form>

</body>
</html>
