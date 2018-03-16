package org.demo.people.creditcard.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class CreditCardTest {

    private CreditCard ccSQUA;
    private CreditCard ccSCO;
    private CreditCard ccPERE;

    @Before
    public void before() {
        LocalDate d = LocalDate.now();
        System.out.println("Before");
        System.out.println(d);

        ccSQUA = new SQUACard();
        ccSCO = new SCOCard();
        ccPERE = new PERECard();
    }

    @Test
    public void testExistence() {
        Assert.assertNotNull(ccSQUA);
        Assert.assertNotNull(ccSCO);
        Assert.assertNotNull(ccPERE);

        Assert.assertEquals("", "SQUACard{}", ccSQUA.toString());
        Assert.assertEquals("", "SCOCard{}", ccSCO.toString());
        Assert.assertEquals("", "PERECard{}", ccPERE.toString());
    }


    @Test
    public void testFake() {
        CreditCard cc2 = new SQUACard(LocalDate.now());
        Assert.assertEquals(672, cc2.serviceFee(), 0.1);
    }

    @Test
    public void testSquaFee() {
        //TODO it should return a double value
        CreditCard cc = new SQUACard(LocalDate.of(2020, 1, 1));
        Assert.assertEquals(2020, cc.serviceFee(), 0.1);
    }

    @Test
    public void testScoFee() {
        CreditCard cc = new SCOCard(LocalDate.of(2017, 3, 15));
        Assert.assertEquals(7.5, cc.serviceFee(), 0.1);
    }

    @Test
    public void testPereFee() {
        CreditCard cc = new PERECard(LocalDate.of(2017, 4, 15));
        Assert.assertEquals(0.4, cc.serviceFee(), 0.1);
    }
}
