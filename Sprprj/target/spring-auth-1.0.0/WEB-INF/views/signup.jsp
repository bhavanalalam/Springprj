<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Signup</title>
</head>
<body>
<h2>User Signup</h2>
<form action="${pageContext.request.contextPath}/auth/signup" method="post">
    Name: <input type="text" name="name" /><br/>
    Email: <input type="email" name="email" /><br/>
    Password: <input type="password" name="password" /><br/>
    <input type="submit" value="Signup"/>
</form>
<a href="${pageContext.request.contextPath}/auth/login">Go to Login</a>
</body>
</html>
