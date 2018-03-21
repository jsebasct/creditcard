package org.demo.people.creditcard.bad;

public class CreditCardDestinationException extends Exception {

    public CreditCardDestinationException() {
        super("El host de la tarjeta de credito esta vacio");
    }

}
