<%--
  Created by IntelliJ IDEA.
  User: 1999g
  Date: 10.11.2018
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>UserList</title>
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>age</th>
        <th>delete</th>
        <th>edit</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="user">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.age}"/></td>
            <td><form action="/deleteUser" method="post">
                <input type="hidden" name="id" value="${user.id}">
                <input type="submit" value="delete">
            </form>
            </td>
            <td>
                <form action="/editUser" method="get">
                    <input type="hidden" name="idchange" value="${user.id}">
                    <input type="hidden" name="namechange" value="${user.name}">
                    <input type="hidden" name="agechange" value="${user.age}">
                    <input type="submit" value="edit">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="${pageContext.servletContext.contextPath}/addUser.jsp">Add User</a>
</body>
</html>
