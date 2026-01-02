<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Food Delivery | Register</title>

<link rel="stylesheet" href="register.css">
</head>

<body>

<div class="register-wrapper">

    <div class="register-card">
        <div class="logo">🍔</div>

        <h2>Create Account</h2>
        <p class="subtitle">Join us & enjoy delicious food anytime</p>

        <form action="RegisterServlet" method="post">

            <div class="input-group">
                <input type="text" name="userName" required>
                <label>User Name</label>
            </div>

            <div class="input-group">
                <input type="email" name="email" required>
                <label>Email Address</label>
            </div>

            <div class="input-group">
                <input type="password" name="password" required>
                <label>Password</label>
            </div>

            <div class="input-group">
                <input type="tel" name="phone" required>
                <label>Phone Number</label>
            </div>

            <!-- ✅ Address Added (No Design Change) -->
            <div class="input-group">
                <textarea name="address" rows="3" required></textarea>
                <label>Address</label>
            </div>

            <button class="register-btn" type="submit">
                Create Account
            </button>

        </form>

        <div class="extra-links">
            <span>Already have an account?</span>
            <a href="userlogin.jsp">Login</a>
        </div>
    </div>

</div>

</body>
</html>
