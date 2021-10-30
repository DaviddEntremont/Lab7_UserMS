<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
    </head>
    <body>
        <h1>All Users</h1>
        <ul>
            <c:forEach items="${users}" var="user">
                <li>${user.email}, ${user.active}, ${user.firstname}, ${user.lastname}, ${user.password}, ${user.role}<br></li>
            </c:forEach>
        </ul>
    </body>
</html>
