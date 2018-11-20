<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
<%
        //编写一个 EncodingFilter
		//1. 读取 web.xml 文件中配置的当前 WEB 应用的初始化参数 encoding
		//2. 指定请求的字符编码为 1 读取到的编码
		//3. 调用 chain.doFilter() 方法 "放行" 请求
    request.setCharacterEncoding("UTF-8");
%>
--%>

Hello:${param.name}

</body>
</html>
