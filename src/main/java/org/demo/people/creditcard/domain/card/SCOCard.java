package org.demo.people.creditcard.domain.card;

import javax.smartcardio.Card;
import java.time.LocalDate;

public class SCOCard extends CreditCard {

    public SCOCard() {
    }

    public SCOCard(LocalDate expirationDate) {
        super(expirationDate);
    }

    public SCOCard(Long number, LocalDate expirationDate) {
        super(number, expirationDate);
    }

    public SCOCard(CardBrand brand, Long number, String cardHolder, LocalDate expirationDate) {
        super(brand, number, cardHolder, expirationDate);
    }

    public CardBrand getBrand() {
        return CardBrand.SCO;
    }

    public double serviceFee() {
        return this.getExpirationDate().getDayOfMonth() * 0.5;
    }
}
