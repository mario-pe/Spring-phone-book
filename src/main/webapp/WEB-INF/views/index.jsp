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
    <title>Index Page</title>
</head>
<body>
<div id="header">
    <h1>Witaj</h1>
    ${info}
    <h3> wybierz co chcesz robic </h3>
</div>
<div id="menu">
    <a href="/person">uzytkownicy</a>
    <a href="/phone">telefony</a>
</div>

<div id="content">
    <h2>Wyszukaj uzytkownika</h2>
    <form action="/searchPerson" method="post">
        <label><h2>wyszukiwanie</h2></label>
        <labal>nazwisko</labal>
        <input type="text" name="surname">
        <labal>numer telefonu</labal>
        <input type="text" name="number">
        <button type="submit">Wyszukaj</button>
    </form>
</div>

</body>
</html>