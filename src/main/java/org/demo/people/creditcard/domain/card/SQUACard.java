package org.demo.people.creditcard.domain.card;

import java.time.LocalDate;

public class SQUACard extends CreditCard {

    public SQUACard() {
    }

    public SQUACard(LocalDate expirationDate) {
        super(expirationDate);
    }

    public SQUACard(Long number, LocalDate expirationDate) {
        super(number, expirationDate);
    }

    public SQUACard(CardBrand brand, Long number, String cardHolder, LocalDate expirationDate) {
        super(brand, number, cardHolder, expirationDate);
    }

    @Override
    public CardBrand getBrand() {
        return CardBrand.SQUA;
    }

    @Override
    public double serviceFee() {
        return getExpirationDate().getYear() / getExpirationDate().getMonthValue();
    }
}
