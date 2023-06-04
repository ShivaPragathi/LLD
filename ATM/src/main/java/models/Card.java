package models;

import java.util.Date;

public class Card {
    private final String cardNumber;
    private final String pin;
    private final String custName;
    private final Date expiryDate;

    public Card(String cardNumber, String pin, String custName, Date expiryDate) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.custName = custName;
        this.expiryDate = expiryDate;
    }
}
