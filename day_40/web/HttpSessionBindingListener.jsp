<%@ page import="com.atguigu.javaweb.test.Customer" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h4>HttpSessionBindingListener</h4>

<%--<%
    Customer customer=new Customer();
    session.setAttribute("customer",customer);

    System.out.println("--------------");

    session.removeAttribute("customer");
%>--%>

<%
    Customer customer = (Customer) session.getAttribute("customer");
    if (customer == null) {
        customer = new Customer();
        customer.setTime("" + new Date());
        session.setAttribute("customer", customer);
        System.out.println("创建一个新的Customer对象:" + customer + ",并放入到session中");
    } else {
        System.out.println("从session中读取到Customer对象：" + customer);
    }
%>

</body>
</html>
