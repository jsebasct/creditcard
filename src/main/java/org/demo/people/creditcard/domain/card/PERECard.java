package org.demo.people.creditcard.domain.card;

import javax.smartcardio.Card;
import java.time.LocalDate;

public class PERECard extends CreditCard {

    public PERECard(Long number, LocalDate expirationDate) {
        super(number, expirationDate);
    }

    public PERECard(CardBrand brand, Long number, String cardHolder, LocalDate expirationDate) {
        super(brand, number, cardHolder, expirationDate);
    }

    public PERECard() {
    }

    public PERECard(LocalDate expirationDate) {
        super(expirationDate);
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
