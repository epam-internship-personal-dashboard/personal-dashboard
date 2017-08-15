<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <%@ include file = "header.jsp" %>
    <body>
        <header id="header">
            <div id="logo-div"><span id="material-icon-acct" class="material-icons">account_circle</span></div>
            <h1>PERSONAL DASHBOARD</h1>
        </header>
        <main id="container">
            <div class="login-container">
                <c:if test="${param.error}">
                    <div class="div-msg">
                        <span id="msg">Invalid username or password!</span>
                    </div>
                </c:if>
                <form action="${pageContext.request.contextPath}/login" method="post">  
                    <label for="username">Username:</label>
                    <div class="div_texbox">
                        <input type="text" class="input-text" name="username" id ="username">
                    </div>
                    <label for="password">Password: </label>
                    <div class="div_texbox">
                        <input type="password" class="input-text" name="password" id="password">
                    </div>
                    <div class="button_div">
                        <input name="Submit" type="submit" value="Login" class="buttons" />
                    </div>
                </form>
            </div>
        </main>
    </body>
</html>