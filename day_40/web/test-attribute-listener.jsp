<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    request.setAttribute("name", "ABCD");
    System.out.println("---------------");

    request.setAttribute("name","DEFG");
    System.out.println("---------------");

    request.removeAttribute("name");
    System.out.println("---------------");
%>

</body>
</html>
