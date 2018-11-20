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
    <title>Add User</title>
</head>
<body>
<form action = "/addUser" method="post">
    Name: <input type="text" name="name" ><br>
    Age: <input type="text" name="age"><br>
    Login: <input type="text" name="login"><br>
    Password: <input type="text" name="password"><br>
    Role: <input type="text" name="role"><br>
    <input type="submit" value="Add user">
</form>
</body>
</html>
