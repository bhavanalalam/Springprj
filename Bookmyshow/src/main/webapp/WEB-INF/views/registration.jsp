<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>
<!-- registration.html -->
<form action="/registrationdata" method="POST">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" th:value="${user.name}" required>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" th:value="${user.email}" required>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" th:value="${user.password}" required>

    <button type="submit">Register</button>

    <!-- Show error or success message if any -->
    <div th:if="${error}" th:text="${error}" style="color: red;"></div>
    <div th:if="${message}" th:text="${message}" style="color: green;"></div>
</form>
</body>
</html>

