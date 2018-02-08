<%--
  Created by IntelliJ IDEA.
  User: Storm
  Date: 27.01.2018
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Редактирование записи</title>
</head>
<body>

<form method="post">
    <c:set var="currentMeal" value='${requestScope["meal"]}'/>
    <input name="id" type="hidden" value="${currentMeal.id}"/> <br><br>
    <c:choose>
        <c:when test='${currentMeal == null}'>
            Дата/Время  <input type="datetime-local" name="dateTime"/> <br><br>
            Описание  <input type="text" name="description"/> <br><br>
            Калории  <input type="number" name="calories"/> <br><br>
        </c:when>

        <c:otherwise>
            <jsp:useBean id="currentMeal" type="ru.javawebinar.topjava.model.Meal"/>
            Дата/Время  <input type="datetime-local" name="dateTime" value="${currentMeal.dateTime}"><br><br>
            Описание  <input type="text" name="description" value="${currentMeal.description}"/> <br><br>
            Калории  <input type="number" name="calories" value="${currentMeal.calories}"/> <br><br>
        </c:otherwise>
    </c:choose>

    <input type="submit" value="Добавить" />


</form>

</body>
</html>
