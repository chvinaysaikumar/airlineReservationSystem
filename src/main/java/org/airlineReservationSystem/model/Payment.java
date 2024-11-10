package org.airlineReservationSystem.model;

public class Payment {
    private int passengerId;
    private double amount;
    private String paymentOption;
    private String transactionId;
    private String status;
    private String cardNumber;
    private String cardHolder;
    private String expiryDate;
    private String cvv;

    // Constructor
    public Payment(int passengerId, double amount, String paymentOption, String transactionId,
                   String status, String cardNumber, String cardHolder, String expiryDate, String cvv) {
        this.passengerId = passengerId;
        this.amount = amount;
        this.paymentOption = paymentOption;
        this.transactionId = transactionId;
        this.status = status;
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    // Getters and Setters
    public int getPassengerId() { return passengerId; }
    public void setPassengerId(int passengerId) { this.passengerId = passengerId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getPaymentOption() { return paymentOption; }
    public void setPaymentOption(String paymentOption) { this.paymentOption = paymentOption; }

    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }

    public String getCardHolder() { return cardHolder; }
    public void setCardHolder(String cardHolder) { this.cardHolder = cardHolder; }

    public String getExpiryDate() { return expiryDate; }
    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }

    public String getCvv() { return cvv; }
    public void setCvv(String cvv) { this.cvv = cvv; }
}