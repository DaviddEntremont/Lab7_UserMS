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
        <p>
            <c:if test="${message eq 'create'}">Note created</c:if>
            <c:if test="${message eq 'update'}">Note updated</c:if>
            <c:if test="${message eq 'delete'}">Note deleted</c:if>
            <c:if test="${message eq 'error'}">Sorry, something went wrong.</c:if>
            </p>
            
    
        
        <form action="" method="GET">
            <ul>

            <c:forEach items="${users}" var="user">
                <li>${user.email}, ${user.firstname}, ${user.lastname}, ${user.password}, ${user.role} Select User: <input type="radio" name="selected" value="${user.email}"><br></li>
            </c:forEach>
        
            </ul>
            <input type="submit" value="Select for Update">
            </form>
            
        

            <h2>Add User</h2>
            <form action="" method="post">
            <label>Email:</label>
            <input type="text" name="email" value=""><br>
            <label>Active User:</label>
            <input type="checkbox" name="active" value="1"><br>
            <label>First Name:</label>
            <input type="text" name="firstname" value=""><br>
            <label>Last Name:</label>
            <input type="text" name="lastname" value=""><br>
            <label>Password:</label>
            <input type="text" name="password" value=""><br>
            <label>Role:</label>
            <select name="role" id="categories" value="">
            <option value="system admin">System Admin</option>
            <option value="regular user">Regular User</option>
            <option value="company admin">Company Admin</option>
            </select>
                <input type="hidden" name="action" value="create">
                <input type="submit" value="Create">
            </form>
            
            <h2>Edit Note</h2>
            <form action="" method="post">
                <label>Email:</label>
            <input type="text" name="email" value="${selecteduser.email}"><br>
            <label>Active User:</label>
            <input type="checkbox" name="active" value=""><br>
            <label>First Name:</label>
            <input type="text" name="firstname" value="${selecteduser.firstname}"><br>
            <label>Last Name:</label>
            <input type="text" name="lastname" value="${selecteduser.lastname}"><br>
            <label>Password:</label>
            <input type="text" name="password" value="${selecteduser.password}"><br>
            <label>Role:</label>
            <select name="role" id="categories" value="${selecteduser.role}">
            <option value="system admin">System Admin</option>
            <option value="regular user">Regular User</option>
            <option value="company admin">Company Admin</option>
            </select>
         
            <input type="hidden" name="action" value="update">
            <input type="submit" value="Update">
            </form>
            
            <form action="" method="post">
            <input type="hidden" name="useremail" value="${selecteduser.email}">
            <input type="hidden" name="action" value="delete">
            <input type="submit" value="Delete">
            </form>
            
    </body>
</html>
