package org.demo.people.creditcard.domain;

import java.time.LocalDate;

public abstract class CreditCard {

    private String brand;
    Long number;
    String cardHolder;
    private LocalDate expirationDate;

    public CreditCard() {
    }

    public CreditCard(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public abstract String getBrand();

    public abstract double serviceFee();

    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}
