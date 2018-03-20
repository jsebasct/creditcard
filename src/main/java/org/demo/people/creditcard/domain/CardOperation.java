package org.demo.people.creditcard.domain;

public class CardOperation {

    public static final Long LIMIT = 1000L;

    public CardOperation(String lastNameOperator) {
    }

    public double getFee(String marca, int importe) {
        return 0.0;
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
