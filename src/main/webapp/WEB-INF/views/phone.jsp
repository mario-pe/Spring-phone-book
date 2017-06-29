
<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 26.06.2017
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Phone page</title>
</head>
<body>

<h3>Lista telefonów</h3>
<%--<c:if test="${!empty phoneList}">--%>
    <table class="tg">
        <tr>
            <th width="10">Id</th>
            <th width="30">Numer</th>
            <th width="30">Numer wewnętrzny</th>
            <th width="30">Numer kierunkowy</th>
        </tr>
        <c:forEach items="${phoneList}" var="phone">
            <tr>
                <td>${phone.id}</td>
                <td>${phone.number}</td>
                <td>${phone.extensionNumber}</td>
                <td>${phone.diallingCode}</td>
                <td><a href="<c:url value='/phone/edit/${phone.id}' />" >Edit</a></td>
                <%--<td><a href="<c:url value='/phone/details/${phone.id}' />" >Szczegoly</a></td>--%>
                <td><a href="<c:url value='/phone/remove/${phone.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
<%--</c:if>--%>

<form action="/phone/add">
    <input type="submit" value="dodaj telefon"/>
</form>


</body>
</html>
