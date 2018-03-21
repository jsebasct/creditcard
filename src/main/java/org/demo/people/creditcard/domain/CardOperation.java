package org.demo.people.creditcard.domain;

import org.demo.people.creditcard.domain.card.CardBrand;
import org.demo.people.creditcard.domain.card.CreditCard;

public class CardOperation {

    public static final Long LIMIT = 1000L;

    private CreditCard card;

    public CardOperation(CreditCard card) {
        this.card = card;
    }

    public double getFeeByService(long importe) {
        double res = 0.0;

        if (isValidOperation(importe)) {
            res = this.card.serviceFee();
        }

        return res;
    }

    /**
     * Una operacion es valida en el sistema si la persona que opera en el
     * mismo consume menos de 1K pesos
     * @param amount
     * @return
     */
    public boolean isValidOperation(long amount) {
        return amount < LIMIT;
    }
}
