package org.demo.people.creditcard.domain;

import java.time.LocalDate;

public abstract class CreditCard {

    private String brand;
    private Long number;
    private String cardHolder;
    private LocalDate expirationDate;

    public CreditCard() {
    }

    public CreditCard(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public CreditCard(Long number, LocalDate expirationDate) {
        this.number = number;
        this.expirationDate = expirationDate;
    }

    public abstract String getBrand();

    public abstract double serviceFee();

    public LocalDate getExpirationDate() {
        return expirationDate;
    }


    public Long getNumber() {
        return number;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    @Override
    public String toString() {
        return getBrand()+"Card{" +
                "brand='" + this.getBrand() + '\'' +
                ", number=" + this.getNumber() +
                ", cardHolder='" + getCardHolder() + '\'' +
                ", expirationDate=" + getExpirationDate() +
                '}';
    }
}
