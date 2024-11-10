package org.airlineReservationSystem.dao;

import org.airlineReservationSystem.model.Passenger;
import org.airlineReservationSystem.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PassengerDAO {

    // Method to save a new passenger to the database
    public void savePassenger(Passenger passenger) throws SQLException {
        String sql = "INSERT INTO Passenger (first_name, last_name, email, phone, passport_number, password) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, passenger.getFirstName());
            statement.setString(2, passenger.getLastName());
            statement.setString(3, passenger.getEmail());
            statement.setString(4, passenger.getPhone());
            statement.setString(5, passenger.getPassportNumber());
            statement.setString(6, passenger.getPassword());

            statement.executeUpdate();
        }
    }

    // Method to find a passenger by their ID
    public Passenger findPassengerById(int passengerId) throws SQLException {
        String sql = "SELECT * FROM Passenger WHERE passenger_id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, passengerId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Passenger passenger = new Passenger();
                passenger.setPassengerId(resultSet.getInt("passenger_id"));
                passenger.setFirstName(resultSet.getString("first_name"));
                passenger.setLastName(resultSet.getString("last_name"));
                passenger.setEmail(resultSet.getString("email"));
                passenger.setPhone(resultSet.getString("phone"));
                passenger.setPassportNumber(resultSet.getString("passport_number"));
                passenger.setPassword(resultSet.getString("password"));
                return passenger;
            }
        }
        return null;  // Return null if no passenger is found
    }

    // Method to update a passenger's information
    public void updatePassenger(Passenger passenger) throws SQLException {
        String sql = "UPDATE Passenger SET first_name = ?, last_name = ?, email = ?, phone = ?, passport_number = ?, password = ? WHERE passenger_id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, passenger.getFirstName());
            statement.setString(2, passenger.getLastName());
            statement.setString(3, passenger.getEmail());
            statement.setString(4, passenger.getPhone());
            statement.setString(5, passenger.getPassportNumber());
            statement.setString(6, passenger.getPassword());
            statement.setInt(7, passenger.getPassengerId());

            statement.executeUpdate();
        }
    }

    // Method to delete a passenger by their ID
    public void deletePassenger(int passengerId) throws SQLException {
        String sql = "DELETE FROM Passenger WHERE passenger_id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, passengerId);
            statement.executeUpdate();
        }
    }

    public Passenger getPassengerById(int passengerId) {
        return null;
    }

}


