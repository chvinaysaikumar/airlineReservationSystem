<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Error</title>
    <link rel="stylesheet" href="path/to/your/style.css">
</head>
<body>
<h1>Error</h1>
<p><%= request.getAttribute("error") %></p>
<a href="reservationForm.jsp">Go back to Reservation Form</a>
</body>
</html>