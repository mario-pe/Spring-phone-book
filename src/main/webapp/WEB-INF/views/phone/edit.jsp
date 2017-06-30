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
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="phone" action="phoneEdit" method="post">
    <label>numer musi miec format "111-111-111" lub "111 111 111"  </label><br/>
    <label>numer</label>
    <form:input path="number"/><form:errors path="number"/><br/>
    <form:hidden path="id" />
    <label>numer wewnetrzny</label>
    <form:input path="extensionNumber"/><form:errors path="extensionNumber"/><br/>
    <label>numer kierunkowy</label>
    <form:input path="diallingCode"/><form:errors path="diallingCode"/><br/>
    <form:button>zapisz</form:button>
</form:form>
<div id="menu">
    <a href="/phone">telefony</a>
    <a href="/index">start</a>
</div>
</body>
</html>
