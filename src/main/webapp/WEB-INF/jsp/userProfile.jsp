<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile | Personal Dashboard</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
    </head>
    <body>    
        <header>
            <h1>PERSONAL DASHBOARD</h1>
            <nav>
                <a href="${pageContext.request.contextPath}/logout">Logout</a>
            </nav>
        </header>
        
        <main>
            <div class="container">
                <p><span><strong>Full Name: </strong> </span>${user.name}</p>
                <p><span><strong>Username: </strong> </span>${user.username}</p>
                <p><span><strong>Birthday: </strong> </span>${user.birthday}</p>
                <p><span><strong>Email: </strong> </span>${user.email}</p>
                <p><span><strong>Gender: </strong> </span>${user.gender}</p>
                <p><span><strong>Role: </strong> </span>${user.role}</p>
            </div>
        </main>
    </body>
</html>