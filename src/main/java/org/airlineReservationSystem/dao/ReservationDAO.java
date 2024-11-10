package org.airlineReservationSystem.dao;

import org.airlineReservationSystem.model.Reservation;
import org.airlineReservationSystem.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {

    // Add a new reservation
    public void addReservation(Reservation reservation) throws SQLException {
        String sql = "INSERT INTO Reservation (passenger_id, flight_id, reservation_date, seat_number) VALUES (?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, reservation.getPassengerId());
            statement.setInt(2, reservation.getFlightId());
            statement.setDate(3, new java.sql.Date(reservation.getReservationDate().getTime()));
            statement.setString(4, reservation.getSeatNumber());

            statement.executeUpdate();

            // Optionally retrieve and set the generated reservation ID
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    reservation.setReservationId(generatedKeys.getInt(1));
                }
            }
        }
    }

    // Retrieve a reservation by ID
    public Reservation getReservationById(int reservationId) throws SQLException {
        String sql = "SELECT * FROM Reservation WHERE reservation_id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, reservationId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapRowToReservation(resultSet);
                }
            }
        }
        return null;
    }

    // Update an existing reservation
    public void updateReservation(Reservation reservation) throws SQLException {
        String sql = "UPDATE Reservation SET passenger_id = ?, flight_id = ?, reservation_date = ?, seat_number = ? WHERE reservation_id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, reservation.getPassengerId());
            statement.setInt(2, reservation.getFlightId());
            statement.setDate(3, new java.sql.Date(reservation.getReservationDate().getTime()));
            statement.setString(4, reservation.getSeatNumber());
            statement.setInt(5, reservation.getReservationId());

            statement.executeUpdate();
        }
    }

    // Delete a reservation by ID
    public void deleteReservation(int reservationId) throws SQLException {
        String sql = "DELETE FROM Reservation WHERE reservation_id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, reservationId);
            statement.executeUpdate();
        }
    }

    // Retrieve all reservations
    public List<Reservation> getAllReservations() throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM Reservation";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                reservations.add(mapRowToReservation(resultSet));
            }
        }
        return reservations;
    }

    // Helper method to map a ResultSet row to a Reservation object
    private Reservation mapRowToReservation(ResultSet resultSet) throws SQLException {
        int reservationId = resultSet.getInt("reservation_id");
        int passengerId = resultSet.getInt("passenger_id");
        int flightId = resultSet.getInt("flight_id");
        Date reservationDate = resultSet.getDate("reservation_date");
        String seatNumber = resultSet.getString("seat_number");

        Reservation reservation = new Reservation(passengerId, flightId, reservationDate, seatNumber);
        reservation.setReservationId(reservationId);
        return reservation;
    }
}
