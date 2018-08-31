<%--
  Created by IntelliJ IDEA.
  User: LK
  Date: 2018/8/30
  Time: 17:40
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

    Hello:<%=request.getParameter("username")%>
    <br><br>

    <%
        session.setAttribute("username",request.getParameter("username"));
    %>

    <a href="<%=response.encodeURL("login.jsp")%>">重新登录</a>
    &nbsp;&nbsp;&nbsp;&nbsp;
    <a href="<%=response.encodeURL("logout.jsp")%>">注销</a>

</body>
</html>
