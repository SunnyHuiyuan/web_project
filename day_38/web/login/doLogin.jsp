<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    //1.获取用户的登陆信息
    String username = request.getParameter("username");

    //2.若登陆信息完整，则把信息放到 HttpSession 里面
    if (username != null && !username.trim().equals("")) {
        session.setAttribute(application.getInitParameter("userSessionKey"), username);
        //3.重定向到list.jsp
        response.sendRedirect("list.jsp");
    } else {
        response.sendRedirect("login.jsp");
    }

%>

</body>
</html>
