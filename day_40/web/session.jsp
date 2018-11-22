<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h4>Session Page</h4>

<%
    HttpSession session = request.getSession(true);
//    session.setMaxInactiveInterval(10);
    session.invalidate();
%>
</body>
</html>
