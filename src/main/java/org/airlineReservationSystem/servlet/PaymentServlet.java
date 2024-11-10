package org.airlineReservationSystem.servlet;

import org.airlineReservationSystem.model.Payment;
import org.airlineReservationSystem.service.PaymentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {

    private PaymentService paymentService;

    @Override
    public void init() throws ServletException {
        paymentService = new PaymentService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int passengerId = Integer.parseInt(request.getParameter("passengerId"));
            double amount = Double.parseDouble(request.getParameter("amount"));
            String paymentOption = request.getParameter("paymentOption");
            String transactionId = request.getParameter("transactionId");
            String status = request.getParameter("status");

            String cardNumber = request.getParameter("cardNumber");
            String cardHolder = request.getParameter("cardHolder");
            String expiryDate = request.getParameter("expiryDate");
            String cvv = request.getParameter("cvv");

            Payment payment = new Payment(passengerId, amount, paymentOption, transactionId, status, cardNumber, cardHolder, expiryDate, cvv);

            paymentService.processPayment(payment);

            response.sendRedirect("paymentSuccess.jsp"); // Redirect to a success page

        } catch (SQLException e) {
            request.setAttribute("error", "Error while processing payment: " + e.getMessage());
            request.getRequestDispatcher("errorPage.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid input values. Please try again.");
            request.getRequestDispatcher("errorPage.jsp").forward(request, response);
        }
    }
}