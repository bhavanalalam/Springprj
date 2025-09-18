<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h2>Welcome, ${user.name}!</h2>
<p>Email: ${user.email}</p>
<a href="${pageContext.request.contextPath}/auth/login">Logout</a>
</body>
</html>
