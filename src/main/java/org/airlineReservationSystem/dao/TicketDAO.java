package org.airlineReservationSystem.dao;

import org.airlineReservationSystem.model.Ticket;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO {
    private Connection connection;

    public TicketDAO(Connection connection) {
        this.connection = connection;
    }

    // Method to get all tickets
    public List<Ticket> getAllTickets() throws SQLException {
        List<Ticket> tickets = new ArrayList<>();
        String query = "SELECT * FROM Tickets";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int ticketId = rs.getInt("ticket_id");
                int reservationId = rs.getInt("reservation_id");
                int seatId = rs.getInt("seat_id");
                double price = rs.getDouble("price");
                tickets.add(new Ticket(ticketId, reservationId, seatId, price));
            }
        }
        return tickets;
    }

    // Method to get ticket by ID
    public Ticket getTicketById(int ticketId) throws SQLException {
        String query = "SELECT * FROM Tickets WHERE ticket_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, ticketId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int reservationId = rs.getInt("reservation_id");
                    int seatId = rs.getInt("seat_id");
                    double price = rs.getDouble("price");
                    return new Ticket(ticketId, reservationId, seatId, price);
                }
            }
        }
        return null;
    }

    // Method to add a new ticket
    public boolean addTicket(Ticket ticket) throws SQLException {
        String query = "INSERT INTO Tickets (reservation_id, seat_id, price) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, ticket.getReservationId());
            ps.setInt(2, ticket.getSeatId());
            ps.setDouble(3, ticket.getPrice());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        }
    }

    // Method to update ticket price
    public boolean updateTicketPrice(int ticketId, double price) throws SQLException {
        String query = "UPDATE Tickets SET price = ? WHERE ticket_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setDouble(1, price);
            ps.setInt(2, ticketId);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        }
    }
}

