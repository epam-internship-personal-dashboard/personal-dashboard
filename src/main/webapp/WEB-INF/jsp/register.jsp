<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <%@ include file = "header.jsp" %>
    <body>
        <header id="header">
            <div id="logo-div"><span id="material-icon-acct" class="material-icons">account_circle</span></div>
            <h1>PERSONAL DASHBOARD</h1>
        </header>
        <main class="container">
            <div id="register-container">
              <h1>Create an Account</h1>
              <f:form action="${pageContext.request.contextPath}/register" method="post" modelAttribute="user">  
                <label for="name">Full Name:</label>
                <div class="div_texbox">
                    <f:input type="text" name="name" path="name" class="input-text" id ="name"/>
                </div>
                
                <label for="username">Username:</label>
                <div class="div_texbox">
                    <f:input type="text" class="input-text" name="username" path="username" id ="username"/>
                </div>
                
                <label for="password">Password:</label>
                <div class="div_texbox">
                    <f:input type="password" name="password" class="input-text" path="password" id ="password"/>
                </div>
                
                <label for="birthday">Birthday:</label>
                <div class="div_texbox">
                    <f:input type="date" name="birthday" class="input-text" path="birthday" id ="birthday"/>
                </div>
                
                <label for="email">Email: </label>
                <div class="div_radio">
                    <f:input type="email" name="email" class="input-text" path="email" id="email"/>
                </div>
                
                <label for="genderMale">Male:</label>
                <div class="div_radio">
                    <f:radiobutton name="gender" class="input-radio" path="gender" value="MALE" id ="genderMale" checked="checked" />
                </div>
                
                <label for="genderFemale">Female:</label>
                <div class="div_texbox">
                    <f:radiobutton name="gender" class="input-radio" path="gender" value="FEMALE" id ="genderFemale" />
                </div>
                 
                <label for="houseNumber">House Number:</label>
                <div class="div_texbox">
                    <f:input type="text" name="houseNumber" class="input-text" path="address.houseNumber" id ="houseNumber" />
                </div>
                
                <label for="street">Street:</label>
                <div class="div_texbox">
                    <f:input type="text" class="input-text" name="street" path="address.street" id ="street" />
                </div>
                
                <label for="zipCode">Zip Code:</label>
                <div class="div_texbox">
                    <f:input type="text" name="zipCode" class="input-text" path="address.zipCode" id ="zipCode" />
                </div>
                
                <label for="city">City:</label>
                <div class="div_texbox">
                    <f:input type="text" name="city" class="input-text" path="address.city" id ="city" />
                </div>
                
                <label for="country">Country:</label>
                <div class="div_texbox">
                    <f:input type="text" name="country" class="input-text" path="address.country" id ="country" />
                </div>
                
                <f:hidden path="role" value="ROLE_USER"/>
                <div class="button_div">
                    <input type="submit" class="buttons" value="Create Accont"/>
                </div>
            
            </f:form>
            <c:if test="${not empty message}">
                <p id="msg">${message}</p>
            </c:if>
            </div>
        </main>
    </body>
</html>