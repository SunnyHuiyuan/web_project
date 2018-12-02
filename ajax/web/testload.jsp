<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="jQuery/jquery-3.3.1.js"></script>
    <script type="text/javascript">

        $(function () {
            $("a").click(function () {
                //使用load方法处理Ajax
                var url = this.href;
                var args = {"time": new Date()};
                $("#content").load(url, args);

                return false;
            })
        })

    </script>
</head>
<body>

<a href="helloAjax.txt">HelloAjax</a>
<div id="content"></div>
</body>
</html>
