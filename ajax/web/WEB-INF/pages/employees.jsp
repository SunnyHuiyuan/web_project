<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jQuery/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jQuery/jquery.blockUI.js"></script>
    <%--
    1.获取#city,添加change响应函数
    2.使#department只保留第一个option子节点
    3.获取#city选择的值，若该值为"",即选择的是请选择，此时不需要发送ajax
    4.若值不为"",说明的确是city发生了改变，准备发送ajax
    4.1 url:employeeServlet?method=listDepartments
    4.2 args:locationId,time
    5.返回的是一个json数组
    5.1 若返回的数组中元素为0：提示，当前城市没有部门
    5.2 若返回的数组中元素不为0：遍历，创建 <option value='departmentId'>departmentName</option>节点,
        并把新创建的option节点加为#department的子节点

    --%>
    <script type="text/javascript">

        $(function () {

            //使用blockUI
            $(document).ajaxStart(function () {
                $.blockUI({
                    message: $('#loading'),
                    css: {
                        top: ($(window).height() - 400) / 2 + 'px',
                        left: ($(window).width() - 400) / 2 + 'px',
                        width: '400px'
                    }
                })
            }).ajaxStop($.unblockUI);

            $("#city").change(function () {
                $("#department option:not(:first)").remove();
                var city = $(this).val();

                if (city != null) {
                    var url = "employeeServlet?method=listDepartments";
                    var args = {"locationId": city, "time": new Date()};

                    $.getJSON(url, args, function (date) {
                        if (date.length == 0) {
                            alert("当前城市没有部门");
                        } else {
                            for (var i = 0; i < date.length; i++) {
                                var deptId = date[i].departmentId;
                                var deptName = date[i].departmentName;

                                $("#department").append("<option value='" + deptId + "'>"
                                    + deptName + "</option>");
                            }
                        }
                    })
                }
            })
        })

    </script>
</head>
<body>

<center>
    <img src="${pageContext.request.contextPath}/pictures/loading.gif"
         alt="" id="loading" style="display:none">
    <br><br>
    City:

    <select id="city">
        <option value="">请选择...</option>
        <c:forEach items="${requestScope.locations}" var="location">
            <option value="${location.locationId}">${location.city}</option>
        </c:forEach>
    </select>

    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

    Department:
    <select id="department">
        <option value="">请选择...</option>
    </select>

    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

    Emplpyee:
    <select id="employee">
        <option value="">请选择...</option>
    </select>

    <br><br>
    <table id="empdetails" border="1" cellspacing="0" cellpadding="5" style="display:none">
        <tr>
            <td>Id</td>
            <td>Name</td>
            <td>Email</td>
            <td>Salary</td>
        </tr>
        <tr>
            <td id="id"></td>
            <td id="name"></td>
            <td id="email"></td>
            <td id="salary"></td>

        </tr>
    </table>

</center>

</body>
</html>
