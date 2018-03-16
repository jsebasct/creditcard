package org.demo.people.creditcard.domain;

import java.time.LocalDate;

public class PERECard extends CreditCard {

    public PERECard(Long number, LocalDate expirationDate) {
        super(number, expirationDate);
    }

    @Override
    public String getBrand() {
        return "PERE";
    }

    @Override
    public double serviceFee() {
        return this.getExpirationDate().getMonthValue() * 0.1;
    }
}
