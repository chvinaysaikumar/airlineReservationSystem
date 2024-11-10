package org.airlineReservationSystem.service;

import org.airlineReservationSystem.dao.AirportDAO;
import org.airlineReservationSystem.model.Airport;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AirportService {
    private AirportDAO airportDAO;

    public AirportService(Connection connection) {
        this.airportDAO = new AirportDAO(connection);
    }

    // Method to get all airports
    public List<Airport> getAllAirports() throws SQLException {
        return airportDAO.getAllAirports();
    }

    // Method to get an airport by ID
    public Airport getAirportById(int airportId) throws SQLException {
        return airportDAO.getAirportById(airportId);
    }

    // Method to add a new airport
    public boolean addAirport(Airport airport) throws SQLException {
        return airportDAO.addAirport(airport);
    }
}

