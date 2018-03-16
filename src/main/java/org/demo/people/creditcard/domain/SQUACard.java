package org.demo.people.creditcard.domain;

import java.time.LocalDate;

public class SQUACard extends CreditCard {

    public SQUACard(Long number, LocalDate expirationDate) {
        super(number, expirationDate);
    }

    @Override
    public String getBrand() {
        return "SQUA";
    }

    @Override
    public double serviceFee() {
        return getExpirationDate().getYear() / getExpirationDate().getMonthValue();
    }
}
