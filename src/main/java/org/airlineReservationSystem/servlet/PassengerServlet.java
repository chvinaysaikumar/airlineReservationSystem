package org.airlineReservationSystem.servlet;

import org.airlineReservationSystem.model.Passenger;
import org.airlineReservationSystem.service.PassengerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/PassengerServlet")
public class PassengerServlet extends HttpServlet {
    private PassengerService passengerService = new PassengerService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve values from the form based on the correct input names
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String passportNumber = request.getParameter("passport_number");
        String password = request.getParameter("password");

        // Populate the Passenger object
        Passenger passenger = new Passenger();
        passenger.setFirstName(firstName);
        passenger.setLastName(lastName);
        passenger.setEmail(email);
        passenger.setPhone(phone);
        passenger.setPassportNumber(passportNumber);
        passenger.setPassword(password);

        // Call service to add the passenger
        try {
            passengerService.addPassenger(passenger);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("passengerSuccess.jsp"); // Redirect after successful sign-in
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle retrieving and displaying passenger information if needed
    }
}
