package org.airlineReservationSystem.service;

import org.airlineReservationSystem.dao.PassengerDAO;
import org.airlineReservationSystem.model.Passenger;

import java.sql.SQLException;

public class PassengerService {
    private PassengerDAO passengerDAO = new PassengerDAO();

    // Add a new passenger
    public void addPassenger(Passenger passenger) throws SQLException {
        passengerDAO.savePassenger(passenger);
    }

    // Retrieve a passenger by their ID
    public Passenger getPassengerById(int passengerId) throws SQLException {
        return passengerDAO.getPassengerById(passengerId);
    }

    // Update an existing passenger's details
    public void updatePassenger(Passenger passenger) throws SQLException {
        passengerDAO.updatePassenger(passenger);
    }

    // Delete a passenger by their ID
    public void deletePassenger(int passengerId) throws SQLException {
        passengerDAO.deletePassenger(passengerId);
    }
}