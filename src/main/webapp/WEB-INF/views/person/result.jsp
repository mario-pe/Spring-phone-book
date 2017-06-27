<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 27.06.2017
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wynik wyszukiwania</title>
</head>
<body>

<c:choose>
    <c:when test="${!empty personList}">
        <h3>lista uzytkownikow</h3>
        <table class="tg">
            <tr>
                <th width="10">Id</th>
                <th width="30">Imie</th>
                <th width="30">Nazwisko</th>
            </tr>
            <c:forEach items="${personList}" var="person">
                <tr>
                    <td>${person.id}</td>
                    <td>${person.name}</td>
                    <td>${person.surname}</td>
                    <td><a href="<c:url value='/person/edit/${person.id}' />">Edit</a></td>
                    <td><a href="<c:url value='/person/details/${person.id}' />">Szczegoly</a></td>
                    <td><a href="<c:url value='/person/remove/${person.id}' />">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <c:out value="brak wyników wyszukiwania"/>
    </c:otherwise>
</c:choose>
<form action="/person/add">
    <input type="submit" value="dodaj uzytkownika"/>
</form>
<form action="/">
    <input type="submit" value="start"/>
</form>
</body>
</html>
