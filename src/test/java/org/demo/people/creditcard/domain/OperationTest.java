package org.demo.people.creditcard.domain;

import org.demo.people.creditcard.domain.card.CreditCard;
import org.demo.people.creditcard.domain.card.PERECard;
import org.demo.people.creditcard.domain.card.SCOCard;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class OperationTest {

    private final Long CARD_NUMBER = 1234_5678_9012_3456L;

    private CreditCard getRandomCard() {
        return new PERECard(CARD_NUMBER, LocalDate.of(2017, 4, 15));
    }

    @Test
    public void testValidOperation() {

        CardOperation operation = new CardOperation(getRandomCard());

        Assert.assertFalse(operation.isValidOperation(1001L));
        Assert.assertTrue(operation.isValidOperation(800L));
    }

    @Test
    public void testFeeOperation() {
        CreditCard card = new SCOCard(CARD_NUMBER, LocalDate.of(2017, 4, 15));
        CardOperation operation = new CardOperation(card);

        int importe = 540;
        double opFee = operation.getFeeByService(importe);

        Assert.assertEquals(7.5, opFee, 0.1);
    }
}
