<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
 <title>Login</title>
</head>
<body>
<h2>User Login</h2>
<form action="${pageContext.request.contextPath}/auth/login" method="post">
    Email: <input type="email" name="email" /><br/>
    Password: <input type="password" name="password" /><br/>
    <input type="submit" value="Login"/>
</form>
<a href="${pageContext.request.contextPath}/auth/signup">Go to Signup</a>
</body>
</html>
