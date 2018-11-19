<%@ page import="com.atguigu.javaweb.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h4>c:out 可以对特殊字符进行转换</h4>

<%
    request.setAttribute("book", "《Java》");
%>
book:${requestScope.book}
<br><br>
book:<c:out value="${requestScope.book2}" escapeXml="false" default="booktitle"></c:out>
<br><br>

<h4>c:set 可以为域赋属性值，其中 value 属性支持 EL 表达式；还可以为域对象中的 JavaBean 的属性赋值，target,value都支持EL表达式</h4>

<c:set var="name" value="atguigu" scope="page"></c:set>
<%--<%
    pageContext.setAttribute("name", "atguigu");
%>--%>
name:${pageScope.name}
<br><br>

<c:set var="subject" value="${param.subject}" scope="session"></c:set>
subject:${sessionScope.subject}
<br><br>

<%
    Customer customer = new Customer();
    customer.setId(1001);
    request.setAttribute("customer", customer);
%>
ID:${requestScope.customer.id}
<br><br>

<c:set target="${requestScope.customer}" property="id" value="${param.id}"></c:set>
ID:${requestScope.customer.id}
<br><br>

<h4>c:remove 移除指定域对象的指定属性值</h4>
<c:set var="date" value="1996-12-01" scope="session"></c:set>
date:${sessionScope.date}
<br><br>
<c:remove var="date" scope="session"></c:remove>
date:${sessionScope.date}
<br><br>

<h4>c:if 没有else，但可以把判断的结果储存起来，以备之后使用</h4>
<c:set var="age" value="20" scope="request"></c:set>
<c:if test="${requestScope.age>18}">成年了！</c:if>
<br><br>
<c:if test="${param.age>18}" var="isAdult" scope="request"></c:if>
idAdult:<c:out value="${requestScope.isAdult}"></c:out>
<br><br>

<h4>
    c:choose,c:when,c:otherwise:可以实现if...else if...else if...else的效果，但较为麻烦
    其中，c:choose 以 c:when,c:otherwise的父标签出现
    c:when,c:otherwise 不能脱离 c:choose 单独使用
    c:otherwise 必须在 c:when 之后使用
</h4>
<c:choose>
    <c:when test="${param.age>60}">
        老年
    </c:when>
    <c:when test="${param.age>40}">
        中年
    </c:when>
    <c:when test="${param.age>18}">
        青年
    </c:when>
    <c:otherwise>
        少年
    </c:otherwise>
</c:choose>
<br><br>

<h4>c:foreach 可以对数组，Collectiong, Map 进行遍历,begin(对于集合begin从0开始算),end,step</h4>
<c:forEach begin="1" end="10" step="3" var="i">
    ${i}--
</c:forEach>
<br><br>
<%
    List<Customer> customers = new ArrayList<>();
    customers.add(new Customer(1, "AA"));
    customers.add(new Customer(2, "BB"));
    customers.add(new Customer(3, "CC"));
    customers.add(new Customer(4, "DD"));
    customers.add(new Customer(5, "EE"));
    customers.add(new Customer(6, "FF"));

    request.setAttribute("customers", customers);
%>
<%--遍历 Collection ,遍历数组同 Collection--%>
<c:forEach items="${requestScope.customers}" var="customer" varStatus="status">
    ${status.index}:${status.count}:${status.first}:${status.last}:${customer.id}:${customer.name}<br>
</c:forEach>
<br><br>

<h4>用 c:foreach 遍历 Map </h4>
<%
    Map<String, Customer> customerMap = new HashMap<>();
    customerMap.put("a", new Customer(1, "AAA"));
    customerMap.put("b", new Customer(2, "BBB"));
    customerMap.put("c", new Customer(3, "CCC"));
    customerMap.put("d", new Customer(4, "DDD"));
    customerMap.put("e", new Customer(5, "EEE"));
    customerMap.put("f", new Customer(6, "FFF"));

    request.setAttribute("customerMap", customerMap);
%>
<c:forEach items="${requestScope.customerMap}" var="customer">
    ${customer.key}-${customer.value.id}-${customer.value.name}<br>
</c:forEach>
<br><br>

<h4>遍历数组</h4>
<%
    String[] names = new String[]{"A", "B", "C"};
    request.setAttribute("names", names);
%>
<c:forEach items="${requestScope.names}" var="name">
    ${name}-
</c:forEach>
<br><br>

<c:forEach items="${pageContext.session.attributeNames}" var="attrName">
    ${attrName}-
</c:forEach>
<br><br>

<h4>c:forTokens 处理字符串的，类似于 String 的 split() 方法</h4>
<c:set value="a,b,c.d.e.f;g;h;i" var="test" scope="request"></c:set>
<c:forTokens items="${requestScope.test}" delims="." var="s">
    ${s}<br>
</c:forTokens>
<br><br>

<h4>c:import 可以包含任何页面到当前页面 </h4>
<c:import url="http://www.baidu.com"></c:import>
<br><br>

<h4>
    c:redirect 使当前JSP页面重定向到指定的页面，其中的/代表当前WEB应用的根目录
    important:交给servlet容器去处理的就代表当前WEB应用的根目录
    交给浏览器去解析的话就代表当前站点的根目录，如下：
    response.sendRedirect("/")中的/代表WEB站点的根目录
</h4>
<%--<c:redirect url="/test.jsp"></c:redirect>--%>
<br><br>

<h4>
    c:url 产生一个 url 地址。可以Cookie是否可用来智能进行URL重写，对GET请求的参数进行编码
    可以吧产生的URL存储在域对象的属性中，
    还可以使用c:param为URL添加参数。c:url会对参数进行自动的转码
    value中的/代表的是当前WEB应用的根目录
</h4>
<c:url value="/test.jsp" var="testurl">
    <c:param name="name" value="尚硅谷"></c:param>
</c:url>
url:${testurl}
</body>
</html>
