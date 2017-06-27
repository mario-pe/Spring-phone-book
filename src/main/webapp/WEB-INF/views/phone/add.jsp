<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 27.06.2017
  Time: 08:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodaj telefon</title>
</head>
<body>
<h1>Dodaj nowy telefon</h1>
<form:form modelAttribute="phone" action="phoneAdding" method="post">
    <label>numer</label>
    <form:input path="number"/><br/>
    <label>numer wewnetrzny</label>
    <form:input path="extensionNumber"/><br/>
    <label>numer kierunkowy</label>
    <form:input path="diallingCode"/><br/>
    <form:button>zapisz</form:button>
</form:form>

</body>
</html>
