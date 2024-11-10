<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tickets List</title>
</head>
<body>
    <h1>Tickets</h1>
    <table border="1">
        <tr>
            <th>Ticket ID</th>
            <th>Reservation ID</th>
            <th>Seat ID</th>
            <th>Price</th>
        </tr>
        <c:forEach var="ticket" items="${tickets}">
            <tr>
                <td>${ticket.ticketId}</td>
                <td>${ticket.reservationId}</td>
                <td>${ticket.seatId}</td>
                <td>${ticket.price
                <td>${ticket.price}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
