package org.demo.people.creditcard.controller;

import org.demo.people.creditcard.domain.CardOperation;
import org.demo.people.creditcard.domain.card.CreditCard;
import org.demo.people.creditcard.domain.card.SCOCard;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class CardOperationController {

    @RequestMapping(value = "/card/dummy")
    public CreditCard getSampleCard() {
        Long CARD_NUMBER = 1234_5678_9012_3456L;
        CreditCard card = new SCOCard(CARD_NUMBER, LocalDate.of(2017, 4, 15));
        card.setCardHolder("Juan Valdez");
        return card;
    }

    @RequestMapping(value = "/card/operation/fee", method = RequestMethod.POST)
    public Double getFeeForService(@RequestParam long importe, @RequestBody CreditCard creditCard) {
        System.out.println("Llego un importe: " + importe);
        System.out.println("Llego una tarjeta: " + creditCard);

        Double result = 0.0;
        CardOperation operation = new CardOperation(creditCard);
        if (operation.isValidOperation(importe)) {
            result = operation.getFeeByService(importe);
        }

        return result;
    }

}
