<%--
  Created by IntelliJ IDEA.
  User: LK
  Date: 2018/8/31
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>验证码</title>
</head>
<body>
    <font color="red">
        <%= session.getAttribute("message")==null?"":session.getAttribute("message")%>
    </font>
    <form action="checkCodeServlet" method="post">
        name:<input type="text" name="name">
        <input type="text" name="CHECK_CODE_PARAM_NAME" >
        <img src="validateColorServlet">
        <input type="submit" value="提交">
    </form>

</body>
</html>
