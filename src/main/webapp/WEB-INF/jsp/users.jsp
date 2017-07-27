<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Users | Personal Dashboard</title>
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
            <c:forEach items="${userDTO}" var="userDTO">
            <tr>
                <td><c:out value="${userDTO.name}"></c:out></td>
                <td><c:out value="${userDTO.username}"></c:out></td>
                <td><c:out value="${userDTO.email}"></c:out></td>
                <td><c:out value="${userDTO.birthday}"></c:out></td>
                <td><c:out value="${userDTO.gender}"></c:out></td>
                <td><c:out value="${userDTO.role}"></c:out></td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </body>
</html>