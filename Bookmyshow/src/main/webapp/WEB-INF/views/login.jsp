<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<!-- login.html -->
<form action="/logindata" method="POST">
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>

    <button type="submit">Login</button>

    <!-- Show error or success message if any -->
    <div th:if="${error}" th:text="${error}" style="color: red;"></div>
    <div th:if="${message}" th:text="${message}" style="color: green;"></div>
</form>
</body>
</html>