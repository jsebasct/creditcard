package org.demo.people.creditcard.required;

import org.demo.people.creditcard.domain.CardOperation;
import org.demo.people.creditcard.domain.card.CreditCard;
import org.demo.people.creditcard.domain.card.PERECard;
import org.demo.people.creditcard.domain.card.SCOCard;

import java.time.LocalDate;

public class ClaseEjecutable {

    private CreditCard cc;

    public ClaseEjecutable() {
        cc = new PERECard(1234_5678_9012_3456L, LocalDate.of(2020, 12, 20));
        cc.setCardHolder("Juan Perez");
    }

    public void aShowInfo() {
        System.out.println("Informacion de una tarjeta");
        System.out.println(cc);
    }

    private void bValidOperation() {
        CardOperation operation = new CardOperation(null);
        System.out.println("Es operacion valida ?" + operation.isValidOperation(1001L));
    }

    private void cValidToOperate() {
        boolean valid = cc.isValidToOperate(LocalDate.now());
        System.out.println("Es  valida para operar ?" + valid);
    }

    private void dIdentifyDifference() {
        cc = new PERECard(1234_5678_9012_3456L, LocalDate.of(2020, 12, 20));
        PERECard ccOtroNum = new PERECard(9234_5678_9012_3456L, LocalDate.of(2020, 12, 20));

        //should be false
        System.out.println("Should be false: " + cc.equals(ccOtroNum));

        cc = new PERECard(1234_5678_9012_3456L, LocalDate.of(2020, 12, 20));
        PERECard ccOtroNum1 = new PERECard(1234_5678_9012_3456L, LocalDate.of(2020, 12, 20));

        //should be true
        System.out.println("Should be true:" + cc.equals(ccOtroNum1));
    }

    private void eTasaOperacion() {
        Long CARD_NUMBER = 1234_5678_9012_3456L;
        CreditCard card = new SCOCard(CARD_NUMBER, LocalDate.of(2017, 4, 15));
        CardOperation operation = new CardOperation(card);

        int importe = 540;
        double opFee = operation.getFeeByService(importe);
        System.out.println("Taza de Operacion " + opFee + " de " + card);
    }

    public static void main(String[] args) {
        ClaseEjecutable exe = new ClaseEjecutable();
        exe.aShowInfo();
        exe.bValidOperation();
        exe.cValidToOperate();
        exe.dIdentifyDifference();
        exe.eTasaOperacion();
    }


}
