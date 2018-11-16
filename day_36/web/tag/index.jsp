<%@ page import="java.util.List" %>
<%@ page import="com.atguigu.javaweb.Customer" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    /**
     * 模拟servlet中的操作
     */
    List<Customer> customers=new ArrayList<Customer>();
    customers.add(new Customer(1,"AA",12));
    customers.add(new Customer(2,"BB",13));
    customers.add(new Customer(3,"CC",14));
    customers.add(new Customer(4,"DD",15));
    customers.add(new Customer(5,"EE",16));

    request.setAttribute("customers",customers);
%>

<jsp:forward page="testtag.jsp"></jsp:forward>

</body>
</html>
