<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rate a Movie</title>
</head>
<body>
    <h2>Rate a Movie</h2>

    <form action="rateMovie" method="post">
        <label for="movieId">Movie ID:</label>
        <input type="text" name="movieId" id="movieId" required><br><br>

        <label for="rating">Rating (1–5):</label>
        <input type="number" name="rating" id="rating" min="1" max="5" required><br><br>

        <input type="submit" value="Submit Rating">
    </form>
</body>
</html>
