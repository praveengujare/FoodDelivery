<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Food Delivery | Login</title>

<link rel="stylesheet" href="userlogin.css">
</head>

<body>

<div class="login-wrapper">

    <div class="login-card">
        <div class="logo">
            🍕
        </div>

        <h2>Welcome Back</h2>
        <p class="subtitle">Login to continue ordering delicious food</p>

        <form action="loginServlet" method="post">

            <div class="input-group">
                <input type="email" name="email" required>
                <label>Email Address</label>
            </div>

            <div class="input-group">
                <input type="password" name="password" required>
                <label>Password</label>
            </div>

            <button class="login-btn" type="submit">
                Login
            </button>

        </form>

        <div class="extra-links">
            <span>New here?</span>
            <a href="register.jsp">Create an account</a>
        </div>
    </div>

</div>

</body>
</html>
