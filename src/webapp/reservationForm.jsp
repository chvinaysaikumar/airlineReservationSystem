<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Flight Reservation</title>
    <link rel="stylesheet" href="path/to/your/style.css">
</head>
<body>
<div class="main">
    <h1>Book Your Flight Reservation</h1>
    <div class="booking-container">
        <h2>Flight Reservation Form</h2>
        <form action="ReservationServlet" method="POST">
            <div class="form-group">
                <label for="passengerId">Passenger ID</label>
                <input type="number" id="passengerId" name="passengerId" required placeholder="Enter Passenger ID">
            </div>
            <div class="form-group">
                <label for="flightId">Flight ID</label>
                <input type="number" id="flightId" name="flightId" required placeholder="Enter Flight ID">
            </div>
            <div class="form-group">
                <label for="reservationDate">Reservation Date</label>
                <input type="date" id="reservationDate" name="reservationDate" required>
            </div>
            <div class="form-group">
                <label for="seatNumber">Seat Number</label>
                <input type="text" id="seatNumber" name="seatNumber" required placeholder="Enter Seat Number">
            </div>
            <button type="submit">Make Reservation</button>
        </form>
    </div>
</div>
</body>
</html>