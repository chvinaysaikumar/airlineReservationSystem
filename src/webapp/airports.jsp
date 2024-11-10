<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Airports List</title>
</head>
<body>
    <h1>Airports</h1>
    <table border="1">
        <tr>
            <th>Airport ID</th>
            <th>Name</th>
            <th>Code</th>
            <th>City</th>
            <th>Country</th>
        </tr>
        <c:forEach var="airport" items="${airports}">
            <tr>
                <td>${airport.airportId}</td>
                <td>${airport.name}</td>
                <td>${airport.code}</td>
                <td>${airport.city}</td>
                <td>${airport.country}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
