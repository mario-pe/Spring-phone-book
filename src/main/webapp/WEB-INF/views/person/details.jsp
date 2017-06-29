<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 27.06.2017
  Time: 08:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Szczegóły</title>
</head>
<body>
<p>Szczegóły dotyczące użytkownik ${person.name} , ${person.surname}</p>
<table>
<c:if test="${!empty phoneList}">
    <h2>lista telefonów</h2>
    <tr>
        <td>id</td>
        <td>numer</td>
        <td>numer kierunkowy</td>
        <td>numer wewnetrzny</td>
    </tr>
    <tr>
    <c:forEach items="${phoneList}" var="phone">
        <tr>
            <td>${phone.id}</td>
            <td>${phone.number}</td>
            <td>${phone.extensionNumber}</td>
            <td>${phone.diallingCode}</td>
            <td> <a href="<c:url value='/removePhoneFromPerson/${phone.id}/${person.id}' />" >Delete</a> </td>
        </tr>
    </c:forEach>
    </tr>
</c:if>

    <h2>dodaj telfon do uzytkownika</h2>
    <form action="/addPhoneToPerson" method="post">
        <label>podaj index telefonu ktroy chcesz podlaczyc</label>
        <input type="text" name="idPhone">
        <input type="hidden" name="idPerson" value="${person.id}">
        <label>jesli numer ma własciela zostanie on na stałe przypisany do nowego uzytkownika</label>
        <button type="submit">dodaj</button>
    </form>
</table>
</body>
</html>
