<%@ page import="ru.javawebinar.topjava.model.MealWithExceed" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Storm
  Date: 25.01.2018
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Meals</title>
</head>
<body>

<%--<%
    List<MealWithExceed> meals = (List<MealWithExceed>)request.getAttribute("meals");
    for (MealWithExceed m : meals) {
        System.out.println(m.toString());
    }

%>--%>
<table cellspacing="20">
    <tr>
        <td>Дата/Время</td> <td>Описание</td> <td>Калории</td> <td></td> <td></td>
    </tr>

<c:forEach var="meal" items='${requestScope["meals"]}'>
    <jsp:useBean id="meal" type="ru.javawebinar.topjava.model.MealWithExceed"/>

    <c:choose>
    <c:when test="${meal.exceed == true}">
    <tr  style="color:red">
    </c:when>
        <c:otherwise>
            <tr  style="color:green">
        </c:otherwise>
    </c:choose>
        <td>${meal.dateTime.toLocalDate().toString()}  ${meal.dateTime.toLocalTime().toString()} </td> <td>${meal.description} </td> <td>${meal.calories} </td> <td>  </td> <td>  </td>

    </tr>


</c:forEach>
</table>

</body>
</html>
