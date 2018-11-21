<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

content:${param.content}
<br><br>

method:<%=request.getMethod()%>
<br><br>

request:<%=request%>

</body>
</html>
