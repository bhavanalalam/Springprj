<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Rating Result</title>
</head>
<body>
    <h2>Rating Submission Result</h2>
    <p>Status: ${status}</p>
    <c:if test="${status eq 'SUCCESS'}">
        <p>User ID: ${rating.userId}</p>
        <p>Movie ID: ${rating.movieId}</p>
        <p>Rating: ${rating.rating}</p>
    </c:if>
</body>
</html>
