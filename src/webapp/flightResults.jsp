<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.airlineReservationSystem.model.Flight" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="refresh" content="4; URL='Searchflight.html'" />
    <script>
        // Optional: Use JavaScript for more control over the redirect
        setTimeout(function() {
            window.location.href = 'Searchflight.html';  // Redirect to secondPage.html
        }, 4000);  // 4 seconds
    </script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Flight Search Results</title>
    <style>
        body {
            font-family: 'Nunito', sans-serif;
            background-color: #f5f5f5;
            text-align: center;
        }
        h2 {
            color: #333;
        }
        table {
            margin: 20px auto;
            border-collapse: collapse;
            width: 80%;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: center;
        }
        th {
            background-color: #0033cc;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #ddd;
        }
        .no-results {
            margin: 20px;
            font-size: 18px;
            color: #888;
        }
    </style>
</head>
<body>
    <h2>Flight Results for Airline: ${param.airline_name}</h2>
    <%
        List<Flight> flights = (List<Flight>) request.getAttribute("flights");
        if (flights != null && !flights.isEmpty()) {
    %>
        <table>
            <tr>
                <th>Flight ID</th>
                <th>Airline Name</th>
                <th>Departure Airport ID</th>
                <th>Arrival Airport ID</th>
                <th>Departure Time</th>
                <th>Arrival Time</th>
                <th>Status</th>
            </tr>
            <%
                for (Flight flight : flights) {
            %>
                <tr>
                    <td><%= flight.getFlightId() %></td>
                    <td><%= flight.getAirlineName() %></td>
                    <td><%= flight.getDepartureAirportId() %></td>
                    <td><%= flight.getArrivalAirportId() %></td>
                    <td><%= flight.getDepartureTime() %></td>
                    <td><%= flight.getArrivalTime() %></td>
                    <td><%= flight.getStatus() %></td>
                </tr>
            <%
                }
            %>
        </table>
    <%
        } else {
    %>
        <div class="no-results">No flights found for the specified airline.</div>
    <%
        }
    %>
</body>
</html>
