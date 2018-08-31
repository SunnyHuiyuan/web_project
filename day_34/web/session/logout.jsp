<%--
  Created by IntelliJ IDEA.
  User: LK
  Date: 2018/8/30
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    SessionID:<%=session.getId()%>
    <br><br>

    IsNew:<%=session.isNew()%>
    <br><br>

    MaxInActiveInternal:<%=session.getMaxInactiveInterval()%>
    <br><br>

    CreatTime:<%=session.getCreationTime()%>
    <br><br>

    LastAccessTime:<%=session.getLastAccessedTime()%>
    <br><br>

    Bye:<%=session.getAttribute("username")%>
    <br><br>

    <a href="login.jsp">重新登录</a>

    <%
        session.invalidate();
    %>



</body>
</html>
