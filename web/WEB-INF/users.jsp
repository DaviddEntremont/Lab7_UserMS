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
        <form action="" method="post">
            <ul>

            <c:forEach items="${users}" var="user">
                <li>${user.email}, ${user.active}, ${user.firstname}, ${user.lastname}, ${user.password}, ${user.role} Select User: <input type="radio" name="selected" value="user"><br></li>
            </c:forEach>
        
            </ul>
        
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
            <input type="submit" value="Select for Update">
            <input type="hidden" name="action" value="select for update">
            </form>
            
        
        <c:if test="${selectedNote eq null}">
            <h2>Add User</h2>
            <form action="users" method="post">
            <label>Email:</label>
            <input type="text" name="email" value=""><br>
            <label>Active User:</label>
            <input type="checkbox" name="active" value="true"><br>
            <label>First Name:</label>
            <input type="text" name="firstname" value=""><br>
            <label>Last Name:</label>
            <input type="text" name="lastname" value=""><br>
            <label>Password:</label>
            <input type="text" name="password" value=""><br>
            <label>Role:</label>
            <select name="role" id="categories" value="${category}">
            <option value="system admin">System Admin</option>
            <option value="regular user">Regular User</option>
            <option value="company admin">Company Admin</option>

                <input type="hidden" name="action" value="create">
                <input type="submit" value="Create">
            </form>
        </c:if>
            
    </body>
</html>
