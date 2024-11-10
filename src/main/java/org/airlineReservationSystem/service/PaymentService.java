package org.airlineReservationSystem.service;

import org.airlineReservationSystem.dao.PaymentDAO;
import org.airlineReservationSystem.model.Payment;

import java.sql.SQLException;

public class PaymentService {
    private PaymentDAO paymentDAO = new PaymentDAO();

    public void processPayment(Payment payment) throws SQLException {
        paymentDAO.savePayment(payment);
    }
}