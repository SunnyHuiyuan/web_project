<%@ page import="com.atguigu.javaweb.Customer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:useBean id="customer" class="com.atguigu.javaweb.Customer" scope="request"></jsp:useBean>

<jsp:useBean id="customer2" beanName="com.atguigu.javaweb.Customer"
             type="java.lang.Object" scope="request"></jsp:useBean>

<%--<%
    Object customer2 = request.getAttribute("customer2");
    if (customer2 == null) {
        customer2 = Class.forName("com.atguigu.javaweb.Customer").newInstance();
        request.setAttribute("customer2", customer2);
    }
%>--%>

<%--若property的值为*，则自动省略value,将自动为所有属性赋值为对应的请求参数的值--%>
<jsp:setProperty name="customer" property="*"></jsp:setProperty>

age:
<jsp:getProperty name="customer" property="age"></jsp:getProperty>
<br>

name:
<jsp:getProperty name="customer" property="name"></jsp:getProperty>
<br>

id:
<jsp:getProperty name="customer" property="id"></jsp:getProperty>
<br>


<%--<%
    customer.setAge(10);
%>--%>

<%--<%=customer.getAge()%>--%>

<%--<%
    /**
     * 1.从scope(session)中获取id(customer)属性值，赋给class(com.atguigu.javaweb.Customer)类型的id(customer)变量
     */
    Customer customer1 = (Customer) session.getAttribute("customer");

    /**
     * 2.若属性值为null,组利用反射创建一个新的对象，把该对象赋给id(customer),并以id(customer)为属性名放入到scope(session)中
     */
    if (customer1 == null) {
        customer1 = (Customer) Class.forName("com.atguigu.javaweb.Customer").newInstance();
        session.setAttribute("customer", customer1);
    }

%>--%>

</body>
</html>
