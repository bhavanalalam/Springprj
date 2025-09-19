<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@page isELIgnored = "false" %>
<html>
<head>
 <title>Login</title>
</head>
<body>
<h2>User Login</h2>
<form action="login" method="post">
    Email: <input type="email" name="email" /><br/>
    Password: <input type="password" name="password" /><br/>
    <input type="submit" value="Login"/>
</form>
<a href="signup">Back</a>
<p>${msg}</p>
</body>
</html>
