package org.demo.people.creditcard.domain;

import org.apache.tomcat.jni.Local;
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

        ccSQUA = new SQUACard(1234_5678_9012_3456L, LocalDate.of(2010, 10, 10));
        ccSQUA.setCardHolder("Jhon Smith");

        ccSCO = new SCOCard(1234_5678_9012_3456L, LocalDate.of(2010, 10, 10));
        ccSCO.setCardHolder("Jhon Smith");

        ccPERE = new PERECard(1234_5678_9012_3456L, LocalDate.of(2010, 10, 10));
        ccPERE.setCardHolder("Jhon Smith");
    }

    @Test
    public void testExistence() {
        Assert.assertNotNull(ccSQUA);
        Assert.assertNotNull(ccSCO);
        Assert.assertNotNull(ccPERE);

        Assert.assertEquals("",
                "SQUACard{brand='SQUA', number=1234567890123456, cardHolder='Jhon Smith', expirationDate=2010-10-10}",
                ccSQUA.toString());

        Assert.assertEquals("",
                "SCOCard{brand='SCO', number=1234567890123456, cardHolder='Jhon Smith', expirationDate=2010-10-10}",
                ccSCO.toString());

        Assert.assertEquals("",
                "PERECard{brand='PERE', number=1234567890123456, cardHolder='Jhon Smith', expirationDate=2010-10-10}",
                ccPERE.toString());
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

    @Test
    public void testValidOperation() {
        Assert.assertFalse(ccPERE.isValidOperation(1000L));
        Assert.assertTrue(ccPERE.isValidOperation(800L));
    }

//    @Test
//    public void testValidToOperate() {
//
//    }
}
