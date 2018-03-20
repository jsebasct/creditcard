package org.demo.people.creditcard.domain.card;

import javax.smartcardio.Card;
import java.time.LocalDate;

public class PERECard extends CreditCard {

    public PERECard(Long number, LocalDate expirationDate) {
        super(number, expirationDate);
    }

    @Override
    public CardBrand getBrand() {
        return CardBrand.PERE;
    }

    @Override
    public double serviceFee() {
        return this.getExpirationDate().getMonthValue() * 0.1;
    }
}
