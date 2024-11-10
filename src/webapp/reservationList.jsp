<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.airlineReservationSystem.model.Reservation" %>
<%@ page import="org.airlineReservationSystem.service.ReservationService" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Reservation List</title>
    <link rel="stylesheet" href="path/to/your/style.css">
</head>
<body>
<h1>All Reservations</h1>

<%
    ReservationService reservationService = new ReservationService();
    List<Reservation> reservations = null;
    try {
        reservations = reservationService.getAllReservations();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>

<table border="1">
    <thead>
        <tr>
            <th>Reservation ID</th>
            <th>Passenger ID</th>
            <th>Flight ID</th>
            <th>Reservation Date</th>
            <th>Seat Number</th>
        </tr>
    </thead>
    <tbody>
        <% for (Reservation reservation : reservations) { %>
            <tr>
                <td><%= reservation.getReservationId() %></td>
                <td><%= reservation.getPassengerId() %></td>
                <td><%= reservation.getFlightId() %></td>
                <td><%= reservation.getReservationDate() %></td>
                <td><%= reservation.getSeatNumber() %></td>
            </tr>
        <% } %>
    </tbody>
</table>
</body>
</html>