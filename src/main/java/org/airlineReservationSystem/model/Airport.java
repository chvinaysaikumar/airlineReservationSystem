package org.airlineReservationSystem.model;

public class Airport {
    private int airportId;
    private String name;
    private String code;
    private String city;
    private String country;

    // Constructors
    public Airport(int airportId, String name, String code, String city, String country) {
        this.airportId = airportId;
        this.name = name;
        this.code = code;
        this.city = city;
        this.country = country;
    }

    // Getters and Setters
    public int getAirportId() {
        return airportId;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
