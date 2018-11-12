<%--
  Created by IntelliJ IDEA.
  User: 1999g
  Date: 09.11.2018
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить нового пользователя</title>
</head>
<body>
<form action = "/addUser" method="post">
    <input type="text" name="name" ><br>
    <input type="text" name="age"><br>
    <input type="submit" value="Add user">
</form>
</body>
</html>
