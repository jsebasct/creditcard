package org.demo.people.creditcard.domain;

import java.time.LocalDate;

public class PERECard extends CreditCard {

    public PERECard() {
    }

    public PERECard(LocalDate expirationDate) {
        super(expirationDate);
    }

    @Override
    public String getBrand() {
        return "PERE";
    }

    @Override
    public double serviceFee() {
        return this.getExpirationDate().getMonthValue() * 0.1;
    }

    @Override
    public String toString() {
        return "PERECard{" +
//                "number=" + number +
//                ", cardHolder='" + cardHolder + '\'' +
                '}';
    }
}
