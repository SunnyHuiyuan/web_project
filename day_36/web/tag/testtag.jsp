<%@ page import="java.util.List" %>
<%@ page import="com.atguigu.javaweb.Customer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--在页面上对request中的customers属性进行遍历，打印id,name,age--%>
<%--用标签的方式遍历--%>
<c:forEach items="${requestScope.customers}" var="customer">
    --${customer.id},${customer.name},${customer.age}<br>
</c:forEach>

<%--传统的用java代码遍历--%>
<%--<%
    List<Customer> customers = (List<Customer>) request.getAttribute("customers");
    if (customers != null) {
        for (Customer customer : customers) {
%>
<%=customer.getId()%>,<%=customer.getName()%>,<%=customer.getAge()%><br>
<%
        }
    }
%>--%>
</body>
</html>
