<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--
    1.获取当前页面的所有a节点，并为其添加onclick响应函数，同时取消默认行为
    2.准备发送ajax请求：  url(a节点的href属性值);args(时间戳)
    3.响应是一个json对象，包括：bookname,totleBookNumber,totleMoney
    4.把对应的属性添加到对应的位置
    --%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jQuery/jquery-3.3.1.js"></script>
    <script type="text/javascript">


        $(function () {
            var isHasCart = "${sessionScope.sc==null}";

            if (isHasCart == "true") {
                $("#cartstatus").hide();
            } else {
                $("#cartstatus").show();

                $("#bookname").text("${sessionScope.sc.bookName}");
                $("#totleBookNumber").text("${sessionScope.sc.totleBookNumber}");
                $("#totleMoney").text("${sessionScope.sc.totleMoney}");
            }

            $("a").click(function () {
                $("#cartstatus").show();

                var url = this.href;
                var args = {"time": new Date()};

                $.getJSON(url, args, function (date) {
                    $("#bookname").text(date.bookName);
                    $("#totleBookNumber").text(date.totleBookNumber);
                    $("#totleMoney").text(date.totleMoney);
                });

                return false;
            })
        })

    </script>
</head>
<body>

<div id="cartstatus">
    您已将&nbsp;<span id="bookname"></span>&nbsp;加入到购物车，
    购物车中的书有&nbsp;<span id="totleBookNumber"></span>&nbsp;本，
    总价格&nbsp;<span id="totleMoney"></span>&nbsp;钱
</div>

<br><br>

Java&nbsp;&nbsp;<a href="addToCart?id=Java&price=100">加入购物车</a>
<br><br>

Oracle&nbsp;&nbsp;<a href="addToCart?id=Oracle&price=200">加入购物车</a>
<br><br>

Struts2&nbsp;&nbsp;<a href="addToCart?id=Struts2&price=100">加入购物车</a>
<br><br>

</body>
</html>
