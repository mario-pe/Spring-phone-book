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



<%--<c:url var="addAction" value="/person/add" ></c:url>--%>

<%--<form:form commandName="person" action="${addAction}" >--%>
    <%--<table>--%>
        <%--<c:if test="${!empty person.name}">--%>
            <%--<tr>--%>
                <%--<td>--%>
                    <%--<form:label path="id">--%>
                        <%--<spring:message text="ID"/>--%>
                    <%--</form:label>--%>
                <%--</td>--%>
                    <%--&lt;%&ndash;<td>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<form:input path="id" readonly="true" size="8"  disabled="true" />&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<form:hidden path="id" />&ndash;%&gt;--%>
                    <%--&lt;%&ndash;</td> &ndash;%&gt;--%>
            <%--</tr>--%>
        <%--</c:if>--%>
        <%--<tr>--%>
            <%--<td>--%>
                <%--<form:label path="name">--%>
                    <%--<spring:message text="Name"/>--%>
                <%--</form:label>--%>
            <%--</td>--%>
            <%--<td>--%>
                <%--<form:input path="name" />--%>
            <%--</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>--%>
                <%--<form:label path="country">--%>
                    <%--<spring:message text="Country"/>--%>
                <%--</form:label>--%>
            <%--</td>--%>
            <%--<td>--%>
                <%--<form:input path="country" />--%>
            <%--</td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td colspan="2">--%>
                <%--<c:if test="${!empty person.name}">--%>
                    <%--<input type="submit"--%>
                           <%--value="<spring:message text="Edit Person"/>" />--%>
                <%--</c:if>--%>
                <%--<c:if test="${empty person.name}">--%>
                    <%--<input type="submit"--%>
                           <%--value="<spring:message text="Add Person"/>" />--%>
                <%--</c:if>--%>
            <%--</td>--%>
        <%--</tr>--%>
    <%--</table>--%>
<%--</form:form>--%>
<%--<br>--%>
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
</body>
</html>