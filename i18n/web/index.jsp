<%@ page import="java.util.Date" %>
<%@ page import="java.util.Locale" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<%
    Date date = new Date();
    request.setAttribute("date", date);

    request.setAttribute("salary", 12345.67);
%>

<%--<fmt:bundle basename="i18n">
    <fmt:message key="date"></fmt:message>
    <fmt:formatDate value="${date}"></fmt:formatDate>,
    <fmt:message key="salary"></fmt:message>
    <fmt:formatNumber value="salary"></fmt:formatNumber>
</fmt:bundle>--%>
<br><br>

<%
    String code = request.getParameter("code");
    if(code!=null){
        if("en".equals(code)){
            session.setAttribute("locale", Locale.US);
        }else if("zh".equals(code)){
            session.setAttribute("locale",Locale.CHINA);
        }
    }
%>

<c:if test="${sessionScope.locale!=null}">
    <fmt:setLocale value="${sessionScope.locale}"></fmt:setLocale>
</c:if>

<fmt:setBundle basename="i18n"></fmt:setBundle>

<fmt:message key="date"></fmt:message>
<fmt:formatDate value="${date}" dateStyle="FULL"></fmt:formatDate>,
<fmt:message key="salary"></fmt:message>
<fmt:formatNumber value="${salary}" type="currency"></fmt:formatNumber>
<br><br>

<a href="index.jsp?code=en">English</a>
<a href="index.jsp?code=zh">中文</a>

</body>
</html>
