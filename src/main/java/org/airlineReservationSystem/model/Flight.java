package org.airlineReservationSystem.model;

public class Flight {
    private int flightId;
    private String airlineName;
    private int departureAirportId;
    private int arrivalAirportId;
    private String departureTime;
    private String arrivalTime;
    private String status;

    // Getters and Setters
    public int getFlightId() { return flightId; }
    public void setFlightId(int flightId) { this.flightId = flightId; }
    public String getAirlineName() { return airlineName; }
    public void setAirlineName(String airlineName) { this.airlineName = airlineName; }
    public int getDepartureAirportId() { return departureAirportId; }
    public void setDepartureAirportId(int departureAirportId) { this.departureAirportId = departureAirportId; }
    public int getArrivalAirportId() { return arrivalAirportId; }
    public void setArrivalAirportId(int arrivalAirportId) { this.arrivalAirportId = arrivalAirportId; }
    public String getDepartureTime() { return departureTime; }
    public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }
    public String getArrivalTime() { return arrivalTime; }
    public void setArrivalTime(String arrivalTime) { this.arrivalTime = arrivalTime; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}