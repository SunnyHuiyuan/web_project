<%--
  Created by IntelliJ IDEA.
  User: LK
  Date: 2018/8/31
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书选购</title>
</head>
<body>

    <h4>Step1:选择要购买的图书</h4>

    <form action="processStep1" method="post">
        <table border="1" cellpadding="10" cellspacing="0">
            <tr>
                <td>书名</td>
                <td>购买</td>
            </tr>
            <tr>
                <td>Java</td>
                <td><input type="checkbox" name="book" value="Java"></td>
            </tr>
            <tr>
                <td>Oracle</td>
                <td><input type="checkbox" name="book" value="Oracle"></td>
            </tr>
            <tr>
                <td>Structs</td>
                <td><input type="checkbox" name="book" value="Structs"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="提交">
                </td>
            </tr>

        </table>
    </form>

</body>
</html>
