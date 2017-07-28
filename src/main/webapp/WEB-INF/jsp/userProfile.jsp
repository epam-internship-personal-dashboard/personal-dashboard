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
                ${user.name}
            </div>
        </main>
    </body>
</html>