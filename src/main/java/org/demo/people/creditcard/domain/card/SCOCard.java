package org.demo.people.creditcard.domain.card;

import java.time.LocalDate;

public class SCOCard extends CreditCard {


    public SCOCard(Long number, LocalDate expirationDate) {
        super(number, expirationDate);
    }

    public String getBrand() {
        return "SCO";
    }

    public double serviceFee() {
        return this.getExpirationDate().getDayOfMonth() * 0.5;
    }
}
