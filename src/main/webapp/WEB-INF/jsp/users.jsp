<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
        <table>
            <thead>
                <th>Name</th>
                <th>Username</th> 
                <th>Email</th>
                <th>Birthday</th>
                <th>Gender</th>
                <th>Role</th>
            </thead>
            <tbody>
            <c:forEach items="${user}" var="user">
            <tr>
                <td><c:out value="${user.name}"></c:out></td>
                <td><c:out value="${user.username}"></c:out></td>
                <td><c:out value="${user.email}"></c:out></td>
                <td><c:out value="${user.birthday}"></c:out></td>
                <td><c:out value="${user.gender}"></c:out></td>
                <td><c:out value="${user.role}"></c:out></td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </body>
</html>