package org.airlineReservationSystem.service;

import org.airlineReservationSystem.dao.ReservationDAO;
import org.airlineReservationSystem.model.Reservation;

import java.sql.SQLException;
import java.util.List;

public class ReservationService {
    private ReservationDAO reservationDAO = new ReservationDAO();

    // Add a new reservation
    public void addReservation(Reservation reservation) throws SQLException {
        reservationDAO.addReservation(reservation);
    }

    // Get a reservation by ID
    public Reservation getReservationById(int reservationId) throws SQLException {
        return reservationDAO.getReservationById(reservationId);
    }

    // Update an existing reservation
    public void updateReservation(Reservation reservation) throws SQLException {
        reservationDAO.updateReservation(reservation);
    }

    // Delete a reservation by ID
    public void deleteReservation(int reservationId) throws SQLException {
        reservationDAO.deleteReservation(reservationId);
    }

    // Retrieve all reservations
    public List<Reservation> getAllReservations() throws SQLException {
        return reservationDAO.getAllReservations();
    }
}