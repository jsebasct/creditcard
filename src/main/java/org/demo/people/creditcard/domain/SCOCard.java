package org.demo.people.creditcard.domain;

import java.time.LocalDate;

public class SCOCard extends CreditCard {

    public SCOCard() {
    }

    public SCOCard(LocalDate expirationDate) {
        super(expirationDate);
    }

    public String getBrand() {
        return "SCO";
    }

    public double serviceFee() {
        return this.getExpirationDate().getDayOfMonth() * 0.5;
    }

    @Override
    public String toString() {
        return "SCOCard{}";
    }
}
