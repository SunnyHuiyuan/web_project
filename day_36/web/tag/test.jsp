<%--导入标签库（描述文件） 建议放在web-inf下 --%>
<%@ taglib prefix="atguigu" uri="http://www.atguigu.com/mytag/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<atguigu:hello value="${param.name}" count="10"></atguigu:hello>
<br>

<atguigu:max num1="${param.a}" num2="${param.b}"></atguigu:max>
<br>

<atguigu:readFile src="/WEB-INF/test.txt"></atguigu:readFile>
<br>
</body>
</html>
