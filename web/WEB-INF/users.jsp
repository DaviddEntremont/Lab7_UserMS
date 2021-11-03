<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
    </head>
    <body>
        <h1>User Management Utility System</h1>

        <form action="" method="GET">
            <h2>Select A User</h2>
            <ul>

            <c:forEach items="${users}" var="user">
                <li><input type="radio" name="selected" value="${user.email}"> ${user.email}, <c:choose><c:when test="${user.active}">Active User</c:when><c:otherwise>Inactive User</c:otherwise></c:choose>, ${user.firstname}, ${user.lastname}, ${user.password}, ${user.role.rolename} <br></li>
            </c:forEach>
        
            </ul>
            <input type="submit" value="Select for Update">
            <br><br>
            <c:if test="${message eq 'selected'}">User ${userfullname} selected!</c:if>
        <c:if test="${selecteduser ne null}">
            <input type="submit" value="Unselect This User?">
        </c:if>
            </form>
        
            
            
        <c:if test="${selecteduser eq null}">
            <h2>Add A User</h2>
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
            <option value="regular user">Select A Role</option>
            <option value="system admin">System Admin</option>
            <option value="regular user">Regular User</option>
            <option value="company admin">Company Admin</option>
            </select>
            <br>
                <input type="hidden" name="action" value="create">
                <input type="submit" value="Create User">
            </form>
            <br>
            <br>
        </c:if>
            
        <c:if test="${selecteduser ne null}">
            <h2>Update User</h2>
            <form action="" method="post">
                <label>Email:</label>
            <input type="text" name="email" value="${selecteduser.email}"><br>
            <label>Active User:</label>
            <input type="checkbox" name="active" value="1"  <c:if test="${activeuser}">checked</c:if>><br>
            <label>First Name:</label>
            <input type="text" name="firstname" value="${selecteduser.firstname}"><br>
            <label>Last Name:</label>
            <input type="text" name="lastname" value="${selecteduser.lastname}"><br>
            <label>Password:</label>
            <input type="text" name="password" value="${selecteduser.password}"><br>
            <label>Role:</label>
            <select name="role" id="categories" value="">
            <option value="system admin" <c:if test="${sadmin}">selected</c:if>>System Admin</option>
            <option value="regular user" <c:if test="${ruser}">selected</c:if>>Regular User</option>
            <option value="company admin" <c:if test="${cadmin}">selected</c:if>>Company Admin</option>
            </select>
            
            <br>
         
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="useremail" value="${selecteduser.email}">
            <input type="submit" value="Update">
            </form>
            
            <form action="" method="post">
            <input type="hidden" name="useremail" value="${selecteduser.email}">
            <input type="hidden" name="action" value="delete">
            <input type="submit" value="Delete">
            </form>    
        </c:if>
            
            <c:if test="${message eq 'update'}">User ${userfullname} updated!</c:if>
            <c:if test="${message eq 'delete'}">User deleted :(</c:if>
            <c:if test="${message eq 'create'}">User ${userfullname} created!</c:if>
            <c:if test="${message eq 'error'}">Sorry, something went wrong.</c:if>
            
    </body>
</html>
