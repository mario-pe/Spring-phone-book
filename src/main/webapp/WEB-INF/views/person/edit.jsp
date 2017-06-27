<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 27.06.2017
  Time: 08:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit</title>
</head>
<body>
<h1> edytujesz uzytkopwnika </h1>


<h1> dodaj użytkownika </h1>


<form:form modelAttribute="person" action="personEdit" method="post">
    <label>imie</label>
    <form:hidden path="id" />
    <form:input path="name"/><br/>
    <label>nazwisko</label>
    <form:input path="surname"/><br/>
    <form:button>zapisz</form:button>
</form:form>
</body>
</html>
