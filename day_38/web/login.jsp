<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<font color="red">${message}</font>
<br><br>

<form action="hello.jsp" method="post">
    username:<input type="text" name="username" value="${param.username}">
    password:<input type="password" name="password">

    <input type="submit" value="Submit">
</form>
</body>
</html>
