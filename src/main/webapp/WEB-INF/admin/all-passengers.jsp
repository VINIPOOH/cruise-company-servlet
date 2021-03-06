<%--
  Created by IntelliJ IDEA.
  User: Tima
  Date: 31.01.2020
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>


<html>
<head>
    <title>Passengers</title>
</head>
<body>
<c:if test="${not empty param.lang}">
    <fmt:setLocale value="${param.lang}" scope="session"/>
</c:if>

<fmt:setBundle basename="message"/>
<ul>
    <li><a href="?lang=en"><fmt:message key="label.lang.en"/></a></li>
    <li><a href="?lang=ru"><fmt:message key="label.lang.ru"/></a></li>
</ul>
<table class="table table-striped table-responsive-md btn-table">
    <thead class="thead-dark">
    <tr>
        <th scope="col"><fmt:message key="table.order.cruise"/></th>
        <th scope="col"><fmt:message key="table.order.first.name"/></th>
        <th scope="col"><fmt:message key="table.order.second.name"/></th>
        <th scope="col"><fmt:message key="table.order.ticket"/></th>
        <th scope="col"><fmt:message key="table.order.price"/></th>
    </tr>
    </thead>

    <tbody>
    <c:choose>
        <c:when test="${passengers.isEmpty()}">
            <h2><fmt:message key="alert.orders.list.is.empty"/></h2>
        </c:when>
        <c:otherwise>
            <c:forEach var="pass" items="${passengers}">
                <tr>
                    <td>${sessionScope.cruise.cruiseName}</td>
                    <td>${pass.firstName}</td>
                    <td>${pass.secondName}</td>
                    <td>${pass.ticket.ticketName}</td>
                    <td>${pass.orderPrice}</td>
                </tr>
            </c:forEach>
        </c:otherwise>
    </c:choose>
    </tbody>
</table>
<a aria-pressed="true" class="btn button" role="button" href="${pageContext.request.contextPath}/main"> <fmt:message
        key="button.main"/></a
</body>
</html>
