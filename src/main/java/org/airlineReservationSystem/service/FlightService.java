package org.airlineReservationSystem.service;

import org.airlineReservationSystem.dao.FlightDAO;
import org.airlineReservationSystem.model.Flight;
import java.util.List;

public class FlightService {
    private FlightDAO flightDAO = new FlightDAO();

    public List<Flight> searchFlightsByAirline(String airlineName) {
        return flightDAO.getFlightsByAirline(airlineName);
    }
}
