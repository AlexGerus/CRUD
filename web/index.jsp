<%--
  Created by IntelliJ IDEA.
  User: 1999g
  Date: 09.11.2018
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>Hello!</title>
  </head>
  <body>
  <form action="/signin" method="post">
    Login:<input type="text" name="login"><br><br>
    Password:<input type="text" name="password"><br>
    <input type="submit" value="Sign In"><br>
  </form>
  <form action="signUp.jsp">
      Are you sign up?<br>
      <input type="submit" value="Sign Up">
  </form>

  </body>
</html>
