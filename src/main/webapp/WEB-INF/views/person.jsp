<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 26.06.2017
  Time: 08:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Person Page</title>
</head>
<body>
<h1>
    operajce na ludziach
</h1>
<h3>lista uzytkownikow</h3>
<c:if test="${!empty personList}">
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
                <td><a href="<c:url value='/person/edit/${person.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/person/details/${person.id}' />" >Szczegoly</a></td>
                <td><a href="<c:url value='/person/remove/${person.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<form action="/person/add">
    <input type="submit" value="dodaj uzytkownika"/>
</form>
<a href="/index">start</a>
</body>
</html>