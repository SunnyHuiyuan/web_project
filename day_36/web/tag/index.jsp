<%@ page import="com.atguigu.javaweb.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: LK
  Date: 2018/9/1
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>标签</title>
</head>
<body>


    <%
        //模拟Servlet中的操作
        List<Customer> customers=new ArrayList<Customer>();
        customers.add(new Customer(1,"AA",18));
        customers.add(new Customer(2,"BB",19));
        customers.add(new Customer(3,"CC",20));
        customers.add(new Customer(4,"DD",21));
        customers.add(new Customer(5,"EE",22));

        request.setAttribute("customers",customers);
    %>
    <%--在页面上对request中的customers属性进行遍历，打印id,name,age--%>
    <jsp:forward page="testtag.jsp"></jsp:forward>

</body>
</html>
