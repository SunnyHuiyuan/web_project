<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--
    1.导入jquery库
    2.获取name="username"的节点：username
    3.为username添加change响应函数
    3.1 获取username的value属性值，去除前后空格且不为空,准备发送ajax请求
    3.2 发送ajax请求，检验username是否可用
    3.3 在服务端直接返回一个html片段
    3.4 咋客户端浏览器把其直接添加到 #message 的html 中
    --%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jQuery/jquery-3.3.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $(":input[name='username']").change(function () {
                var val = $(this).val();
                val = $.trim(val);

                if (val != null) {
                    var url = "${pageContext.request.contextPath}/valiateUsername";
                    var args = {"username": val, "time": new Date()};

                    $.post(url, args, function (date) {
                        $("#message").html(date);
                    })
                }
            })
        })
    </script>
</head>
<body>

<form action="" method="post">

    Username:<input type="text" name="username">
    <br>
    <div id="message"></div>
    <br>
    <input type="submit" value="Submit">

</form>

</body>
</html>
