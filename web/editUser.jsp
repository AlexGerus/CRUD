<%--
  Created by IntelliJ IDEA.
  User: 1999g
  Date: 12.11.2018
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<form action="/editUser" method="post">
    <input type="text" name="idchange" value="${idchange}"><br>
    <input type="text" name="namechange" value="${namechange}"><br>
    <input type="text" name="agechange" value="${agechange}"><br>
    <input type="submit" value="Edit User">
</form>
</body>
</html>
