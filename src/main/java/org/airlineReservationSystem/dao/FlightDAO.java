package org.airlineReservationSystem.dao;

import org.airlineReservationSystem.model.Flight;
import org.airlineReservationSystem.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightDAO {
    public List<Flight> getFlightsByAirline(String airlineName) {
        List<Flight> flights = new ArrayList<>();
        String query = "SELECT * FROM Flights WHERE airline_name = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, airlineName);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Flight flight = new Flight();
                flight.setFlightId(rs.getInt("flight_id"));
                flight.setAirlineName(rs.getString("airline_name"));
                flight.setDepartureAirportId(rs.getInt("departure_airport_id"));
                flight.setArrivalAirportId(rs.getInt("arrival_airport_id"));
                flight.setDepartureTime(rs.getString("departure_time"));
                flight.setArrivalTime(rs.getString("arrival_time"));
                flight.setStatus(rs.getString("status"));
                flights.add(flight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flights;
    }
}
