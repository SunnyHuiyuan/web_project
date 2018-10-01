<%@ page import="java.util.List" %>
<%@ page import="com.atguigu.javaweb.Customer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: LK
  Date: 2018/9/1
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%--在页面上对request中的customers属性进行遍历，打印id,name,age--%>
    <c:forEach items="${requestScope.customers}" var="customer">
        --${customer.id},${customer.name},${customer.age}
        <br>
    </c:forEach>

    <%--<%
        //原始方法
        List<Customer> customers=(List<Customer>) request.getAttribute("customers");

        if (customers !=null){
            for(Customer customer:customers){
    %>

    <%=customer.getId()%>,<%=customer.getName()%>,<%=customer.getAge()%>
    <br>

    <%        }
        }
    %>--%>

</body>
</html>
