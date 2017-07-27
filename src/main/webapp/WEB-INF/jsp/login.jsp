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
        <nav id="main-menu">
        </nav>
        <section>
            <div class="container centered">
              <form action="${pageContext.request.contextPath}/login" method="post">  
                <label>Userame:</label>
                <input type="text" name="username"><br>  
                <label>Password: </label>
                <input type="password" name="password"><br>  
            <input type="submit" value="login">  
            </form>
            <c:if test="${not empty message}">
                <p id="msg">${message}</p>
            </c:if>
            </div>
        </section>
    </body>
</html>