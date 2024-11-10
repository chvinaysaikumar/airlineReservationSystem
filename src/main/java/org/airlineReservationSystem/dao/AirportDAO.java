package org.airlineReservationSystem.dao;

import org.airlineReservationSystem.model.Airport;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirportDAO {
    private Connection connection;

    public AirportDAO(Connection connection) {
        this.connection = connection;
    }

    // Method to get a list of all airports
    public List<Airport> getAllAirports() throws SQLException {
        List<Airport> airports = new ArrayList<>();
        String query = "SELECT * FROM Airports";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int airportId = rs.getInt("airport_id");
                String name = rs.getString("name");
                String code = rs.getString("code");
                String city = rs.getString("city");
                String country = rs.getString("country");
                airports.add(new Airport(airportId, name, code, city, country));
            }
        }
        return airports;
    }

    // Method to get an airport by its ID
    public Airport getAirportById(int airportId) throws SQLException {
        String query = "SELECT * FROM Airports WHERE airport_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, airportId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("name");
                    String code = rs.getString("code");
                    String city = rs.getString("city");
                    String country = rs.getString("country");
                    return new Airport(airportId, name, code, city, country);
                }
            }
        }
        return null;
    }

    // Method to add a new airport
    public boolean addAirport(Airport airport) throws SQLException {
        String query = "INSERT INTO Airports (name, code, city, country) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, airport.getName());
            ps.setString(2, airport.getCode());
            ps.setString(3, airport.getCity());
            ps.setString(4, airport.getCountry());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        }
    }
}
