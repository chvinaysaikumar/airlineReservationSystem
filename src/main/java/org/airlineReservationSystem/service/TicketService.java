package org.airlineReservationSystem.service;

import org.airlineReservationSystem.dao.TicketDAO;
import org.airlineReservationSystem.model.Ticket;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TicketService {
    private TicketDAO ticketDAO;

    public TicketService(Connection connection) {
        this.ticketDAO = new TicketDAO(connection);
    }

    // Method to get all tickets
    public List<Ticket> getAllTickets() throws SQLException {
        return ticketDAO.getAllTickets();
    }

    // Method to get ticket by ID
    public Ticket getTicketById(int ticketId) throws SQLException {
        return ticketDAO.getTicketById(ticketId);
    }

    // Method to add a new ticket
    public boolean addTicket(Ticket ticket) throws SQLException {
        return ticketDAO.addTicket(ticket);
    }

    // Method to update ticket price
    public boolean updateTicketPrice(int ticketId, double price) throws SQLException {
        return ticketDAO.updateTicketPrice(ticketId, price);
    }
}
