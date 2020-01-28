<%--
  Created by IntelliJ IDEA.
  User: Tima
  Date: 27.01.2020
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false"%>

<html>
<head>
    <title>Main</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/balance"> replenish</a>
<table class="table table-striped table-responsive-md btn-table">
    <thead class="thead-dark">
    <tr>
        <th scope="col"> Name</th>
        <th scope="col"> Description</th>
        <th scope="col"> DescriptionRu</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="cruise" items="${cruises}">
        <tr>
            <td>${cruise.cruiseName}</td>
            <td>${cruise.descriptionEng}</td>
            <td>${cruise.descriptionRu}</td>
                <%--            <td>--%>
                <%--                <form action="user" method="post">--%>
                <%--                    <input type="hidden" name="command" value="processExposition"/>--%>
                <%--                    <input type="hidden" name="expositionId" value="${exposition.getId()}"/>--%>
                <%--                    <button type="submit" class="btn btn-success"><fmt:message key="user.showExpositions.order"/></button>--%>
                <%--                </form>--%>
                <%--            </td>--%>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
