package org.airlineReservationSystem.model;

import java.util.Date;

public class Reservation {
    private int reservationId;
    private int passengerId;
    private int flightId;
    private Date reservationDate;
    private String seatNumber;

    // Constructor
    public Reservation(int passengerId, int flightId, Date reservationDate, String seatNumber) {
        this.passengerId = passengerId;
        this.flightId = flightId;
        this.reservationDate = reservationDate;
        this.seatNumber = seatNumber;
    }

    // Getters and Setters
    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
}