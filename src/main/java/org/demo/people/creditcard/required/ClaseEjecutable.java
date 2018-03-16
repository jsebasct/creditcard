package org.demo.people.creditcard.required;

import org.demo.people.creditcard.domain.CreditCard;
import org.demo.people.creditcard.domain.PERECard;

import java.time.LocalDate;

public class ClaseEjecutable {

    private CreditCard cc;

    public ClaseEjecutable() {
        cc = new PERECard(1234_5678_9012_3456L, LocalDate.now());
        cc.setCardHolder("Juan Perez");
    }

    public void aShowInfo() {
        System.out.println("Informacion de una tarjeta");
        System.out.println(cc);
    }

    public static void main(String[] args) {
        ClaseEjecutable exe = new ClaseEjecutable();
        exe.aShowInfo();
    }
}
