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
            <td><a href="meals?action=update&itemId=${item.getId()}">update</a></td>
            <td><a href="meals?action=delete&itemId=${item.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
<a href="meals?action=create">do an create</a>
</body>
</html>
