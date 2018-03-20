package org.demo.people.creditcard.required;

import org.demo.people.creditcard.domain.card.CreditCard;
import org.demo.people.creditcard.domain.card.PERECard;

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

    //TODO valid operation
//    private void bValidOperation() {
//        boolean valid = cc.isValidOperation(1500L);
//        System.out.println("Es operacion valida ?" + valid);
//    }

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



    public static void main(String[] args) {
        ClaseEjecutable exe = new ClaseEjecutable();
        exe.aShowInfo();
//        exe.bValidOperation();
        exe.cValidToOperate();
        exe.dIdentifyDifference();
    }


}
