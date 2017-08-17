<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <%@ include file = "header.jsp" %>
    <body id="body-tag">
        <header id="header">
            <div id="logo-div"><span id="material-icon-acct" class="material-icons">account_circle</span></div>
            <h1>PERSONAL DASHBOARD</h1>
        </header>
        
        <main id="container">
            <div class="flex-container">
              <div class="flex-item-1">
                  <div class="notification">
                      <div class="flex-item-1-2-3" id="photo">
                        <img id="profile-avatar" src="https://wordsmith.org/words/images/avatar2_large.png" alt="Profile Avatar">
                      </div>
                      <div class="flex-item-1-2-3" id="alert">
                       <span id="msg-icon" class="material-icons">email</span><span id="alert-icon">1</span>
                      </div>
                  </div>
                  
                  <div class="box">
                    <div class="box-header">
                        <h1>User Details</h1>
                    </div>
                    <div class="box-content">
                       <div class="box-content-body">
                           <div class="body-items">
                                <p><span class="label-style">Full Name:  </span>${user.name}</p>
                                <p><span class="label-style">Username:  </span>${user.username}</p>
                                <p><span class="label-style">Role:  </span>${user.role}</p>
                                <p><span class="label-style">Email:  </span>${user.email}</p>
                           </div>
                       </div>
                       <div class="box-content-add">
                           <span id="add-btn-1" class="box-add-btn material-icons">add_box</span>
                       </div>
                    </div>
                  </div>
              </div>
             
              <div class="flex-item-1">
                <div class="box">
                  <div class="box-header">
                       <h1>To-Do List</h1>
                    </div>
                    <div class="box-content">
                       <div class="box-content-body">
                           <div class="body-items">
                               <input type="checkbox" name="chk-item1" id="chk-item1" value="buyGroceries">
                               <label class="label-style" for="chk-item1">Buy groceries</label>                      
                           </div>
                           <div class="body-items">
                               <input type="checkbox" name="chk-item2" id="chk-item2" value="walkDog">
                               <label class="label-style" for="chk-item2">Walk the dog</label>
                           </div>
                       </div>
                       <div class="box-content-add">
                           <span id="add-btn-2" class="box-add-btn material-icons">add_box</span>
                       </div>
                    </div>
                </div>    
              </div>
            </div>

        </main>
    </body>
</html>