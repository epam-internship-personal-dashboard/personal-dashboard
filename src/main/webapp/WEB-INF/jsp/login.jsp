<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login | Personal Dashboard</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
    </head>
    <body>
        <header>
            <h1>PERSONAL DASHBOARD</h1>
        </header>
        <main>
            <div class="login-container">
              <form action="${pageContext.request.contextPath}/login" method="post">  
                <label for="username">Userame:</label>
                <input type="text" name="username" id ="username">
                <label for="password">Password: </label>
                <input type="password" name="password" id="password">
            <input type="submit" value="login">  
            </form>
            <c:if test="${not empty message}">
                <p id="msg">${message}</p>
            </c:if>
            </div>
        </main>
    </body>
</html>