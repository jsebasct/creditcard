package org.demo.people.creditcard.domain;

import org.junit.Assert;
import org.junit.Test;

public class OperationTest {

    @Test
    public void testValidOperation() {

        CardOperation operation = new CardOperation("");

        Assert.assertFalse(operation.isValidOperation(1000L));
        Assert.assertTrue(operation.isValidOperation(800L));
    }

//    @Test
//    public void feeOperation() {
//        String lastNameOperator = "Smith";
//        CardOperation operation = new CardOperation(lastNameOperator);
//        int importe = 100;
//        double opFee = operation.getFee("marca", importe);
//
//        Assert.assertEquals(100.1, opFee, 0.1);
//    }
}
