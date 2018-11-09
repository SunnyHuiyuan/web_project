<%@ page import="com.atguigu.javaweb.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--1：el的.或[]运算符--%>
age:${sessionScope.customer.age}
<br>
age:${sessionScope.customer["age"]}
<br><br>

<%--相当于以下的代码--%>
<%--<%
    Customer customer1 = (Customer) session.getAttribute("customer");
    out.print(customer1.getAge());
%>--%>


<%--2：el中的隐含对象--%>
<%
    Customer customer = new Customer();
    customer.setName("local");
    session.setAttribute("com.atguigu.customer", customer);
%>
<%--
如果域对象中的属性名带有特殊字符，使用[]会很方便
--%>
name:${sessionScope["com.atguigu.customer"].name}
<br>

<a>作用域由小到大的查找</a>
<%
    Customer customer1 = new Customer();
    customer1.setAge(28);
    request.setAttribute("customer", customer1);
%>
<br>
age:${customer.age}
<br>
age:${sessionScope.customer.age}
<br><br>


<%--3：el可以进行自动的类型转换--%>
score:${param.score+11}
<br>
score:<%=request.getParameter("score") + 11%>
<br><br>


<%--4:隐含对象之与范围相关的：pageScope,requestScope,seesionScope,applicationScope--%>
time:${time}
<br>
<%--相当于如下代码--%>
time:<%=application.getAttribute("time")%>
<br><br>


<%--5:与输入有关的隐含对象：param,paramValues--%>
score:${param.score}
<%--相当于下面代码
<%=request.getParameter("score")%>
--%>
<br>
names:${paramValues.name[0]}
<br>
<%--相当于下面的代码--%>
<%=
request.getParameterValues("name")[0].getClass().getName()
%>
<br><br>


<%--6:其他隐含对象：cookie,pageContext等--%>
<%--cookie用来获取cookie的name或者value--%>
JSESSIONID:${cookie.JSESSIONID.name}---${cookie.JSESSIONID.value}
<br>

<%--header和headerValue用来获取请求头--%>
Accept-Language:${header["Accept-Language"]}
<br>

<%--获取当前web应用的初始化参数--%>
initParam:${initParam.initName}
<br>

<%--重点--pageContext--%>
pageContext:pageContext即为pageContext类型，但只能读取属性（利用getXxx方法）,只要有只读属性，就可以一直.下去
<br>
contextPath:${pageContext.request.contextPath}
<br>
sessionId:${pageContext.session.id}
<br>
sessionAttributeNames:${pageContext.session.attributeNames}
<br><br>


<%--7:el的关系运算符--%>
${param.score>60?"及格":"不及格"}
<br>

<%
    List<String> names = new ArrayList<String>();
    request.setAttribute("names",names);
    names.add("local");
%>
<%--empty可以作用于一个集合，若该集合不存在或者集合中元素为空，其结果都为true--%>
names is empty:${empty requestScope.names}
</body>
</html>
