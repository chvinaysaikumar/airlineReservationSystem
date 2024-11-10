package org.airlineReservationSystem.model;

public class Ticket {
    private int ticketId;
    private int reservationId;
    private int seatId;
    private double price;

    // Constructors
    public Ticket(int ticketId, int reservationId, int seatId, double price) {
        this.ticketId = ticketId;
        this.reservationId = reservationId;
        this.seatId = seatId;
        this.price = price;
    }

    // Getters and Setters
    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

