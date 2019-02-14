<%--
  Created by IntelliJ IDEA.
  User: Seichi
  Date: 12.02.2019
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Meals</title>
    <link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<table>
    <tr>
        <th>"Время"</th>
        <th>"Описание"</th>
        <th>"Калории"</th>
    </tr>
    <c:forEach items="${list}" var="item">
        <tr style="background: ${item.isExcess() ? "red" : "lightgreen"}">
            <td>
                <fmt:parseDate value="${item.getDateTime()}" pattern="yyyy-MM-dd'T'HH:mm" dateStyle="short" var="parsedDateTime" type="both" />
                <fmt:formatDate var="formattedDateTime" pattern="dd.MM.yyyy HH:mm" value="${parsedDateTime}"/>
                <c:out value="${formattedDateTime}"/>
            </td>
            <td><c:out value="${item.getDescription()}"/></td>
            <td><c:out value="${item.getCalories()}"/></td>

        </tr>
    </c:forEach>
</table>
<h4>Add meal</h4>
<table>
    <tr>
        <th>Date and time of yer meal</th>
        <th>What is the description of yer meal</th>
        <th>How many calories do you expect from yer meal</th>
    </tr>
    <tr>
        <td><input type="datetime-local"/></td>
        <td><input/></td>
        <td><input type="number"/></td>
    </tr>
</table>
<input type="submit"/>
</body>
</html>
