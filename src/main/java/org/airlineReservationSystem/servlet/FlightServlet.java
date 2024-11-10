package org.airlineReservationSystem.servlet;

import org.airlineReservationSystem.model.Flight;
import org.airlineReservationSystem.service.FlightService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/FlightServlet")
public class FlightServlet extends HttpServlet {
    private final FlightService flightService = new FlightService();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String airlineName = request.getParameter("airline_name");
        List<Flight> flights = flightService.searchFlightsByAirline(airlineName);
        request.setAttribute("flights", flights);
        request.getRequestDispatcher("flightResults.jsp").forward(request, response);

    }
}