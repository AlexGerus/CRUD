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
    Id: <input type="text" name="idchange" value="${idchange}"><br>
    New Name: <input type="text" name="namechange" value="${namechange}"><br>
    New Age: <input type="text" name="agechange" value="${agechange}"><br>
    New Role: <input type="text" name="rolechange" value="${rolechange}"><br>
    New Login: <input type="text" name="loginchange" value="${loginchange}"><br>
    New Password: <input type="text" name="passwordchange" value="${passwordchange}"><br>
    <input type="submit" value="Edit User">
</form>
</body>
</html>
