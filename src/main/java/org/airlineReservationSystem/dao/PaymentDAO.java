package org.airlineReservationSystem.dao;

import org.airlineReservationSystem.model.Payment;
import org.airlineReservationSystem.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentDAO {
    public void savePayment(Payment payment) throws SQLException {
        String sql = "INSERT INTO Payment (passenger_id, amount, payment_option, transaction_id, status, card_number, card_holder, expiry_date, cvv) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, payment.getPassengerId());
            statement.setDouble(2, payment.getAmount());
            statement.setString(3, payment.getPaymentOption());
            statement.setString(4, payment.getTransactionId());
            statement.setString(5, payment.getStatus());
            statement.setString(6, payment.getCardNumber());
            statement.setString(7, payment.getCardHolder());
            statement.setString(8, payment.getExpiryDate());
            statement.setString(9, payment.getCvv());

            statement.executeUpdate();
        }
    }
}