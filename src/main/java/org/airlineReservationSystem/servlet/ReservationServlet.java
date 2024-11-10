package org.airlineReservationSystem.servlet;

import org.airlineReservationSystem.service.ReservationService;
import org.airlineReservationSystem.model.Reservation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/ReservationServlet")
public class ReservationServlet extends HttpServlet {

    private ReservationService reservationService;

    @Override
    public void init() throws ServletException {
        reservationService = new ReservationService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int passengerId = Integer.parseInt(request.getParameter("passengerId"));
            int flightId = Integer.parseInt(request.getParameter("flightId"));
            String seatNumber = request.getParameter("seatNumber");

            // Parse reservation date with error handling
            String dateStr = request.getParameter("reservationDate");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date reservationDate = dateFormat.parse(dateStr);

            Reservation reservation = new Reservation(passengerId, flightId, reservationDate, seatNumber);

            reservationService.addReservation(reservation);
            response.sendRedirect("reservationList.jsp"); // Redirect to confirmation page

        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid Passenger ID or Flight ID. Please enter valid numbers.");
            request.getRequestDispatcher("errorPage.jsp").forward(request, response);
        } catch (ParseException e) {
            request.setAttribute("error", "Invalid reservation date format. Please use yyyy-MM-dd.");
            request.getRequestDispatcher("errorPage.jsp").forward(request, response);
        } catch (SQLException e) {
            request.setAttribute("error", "Error while adding reservation: " + e.getMessage());
            request.getRequestDispatcher("errorPage.jsp").forward(request, response);
        }
    }
}