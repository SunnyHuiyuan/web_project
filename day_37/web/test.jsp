<%@ page import="com.atguigu.javaweb.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ taglib prefix="atguigu" uri="http://www.atguigu.com/myTag/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<atguigu:testJspFragment>Hello:${param.name}</atguigu:testJspFragment>
<br>

<atguigu:printUpper time="10">java.com</atguigu:printUpper>
<br>

<%
    List<Customer> customers = new ArrayList<Customer>();

    customers.add(new Customer(1, "AA"));
    customers.add(new Customer(2, "BB"));
    customers.add(new Customer(3, "CC"));
    customers.add(new Customer(4, "DD"));
    customers.add(new Customer(5, "EE"));
    customers.add(new Customer(6, "FF"));

    request.setAttribute("customers", customers);

    Map<String, Customer> customerMap = new HashMap<>();

    customerMap.put("a", customers.get(0));
    customerMap.put("b", customers.get(1));
    customerMap.put("c", customers.get(2));
    customerMap.put("d", customers.get(3));
    customerMap.put("e", customers.get(4));
    customerMap.put("f", customers.get(5));

    request.setAttribute("customerMap", customerMap);
%>
<b>通过标准的forEach循环遍历</b>
<br>
<c:forEach items="${requestScope.customers}" var="customer">
    ${customer.id}---${customer.name} <br>
</c:forEach>
<br><br>

<b>通过标准的forEach循环遍历Map</b>
<br>
<c:forEach items="${requestScope.customerMap}" var="customer">
    ${pageScope.customer.key}->->${customer.value.id}->->${customer.value.name} <br>
</c:forEach>
<br><br>

<b>通过自定义的forEach遍历循环</b>
<br>
<atguigu:forEach items="${requestScope.customers}" var="customer">
    ${customer.id}->->${customer.name} <br>
</atguigu:forEach>
<br><br>

<b>父标签和子标签的使用</b><br>
<%--父标签打印 name 到控制台--%>
<atguigu:parentTag>
    <%--子标签以父标签的标签体存在，子标签把父标签的 name 属性打印到 JSP 页面上--%>
    <atguigu:sonTag/>
</atguigu:parentTag>
<br><br>

<atguigu:choose>
    <atguigu:when test="${param.age>24}">--大学毕业</atguigu:when>
    <atguigu:when test="${param.age>20}">--高中毕业</atguigu:when>
    <atguigu:otherwise>--高中以下......</atguigu:otherwise>
</atguigu:choose>
<br><br>

<%--使用一个 EL 自定义函数--%>
${fn:length(param.name)}
<br><br>

<%--转为大写--%>
${fn:toUpperCase(param.name1)}
<br><br>

<%--测试自定义的EL函数--%>
${atguigu:concat(param.name1,param.name2)}
</body>
</html>
