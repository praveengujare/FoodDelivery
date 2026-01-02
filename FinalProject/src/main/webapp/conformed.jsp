<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.tap.Model.userModel" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thank You</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: #f4f7fb;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .thank-you {
        background: white;
        padding: 40px;
        border-radius: 12px;
        box-shadow: 0 10px 25px rgba(0,0,0,0.1);
        text-align: center;
    }
    h1 {
        color: #28a745;
    }
</style>

</head>
<body>

<%
userModel user = (userModel) session.getAttribute("user");
%>

<div class="thank-you">
    <h1>Thank You, <%= user != null ? user.getUserName(): "Guest" %>! 😊</h1>
    <p>Your order has been placed successfully.</p>
    <p>We hope you enjoy your meal 🍕</p>
</div>

</body>
</html>
    