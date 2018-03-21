package org.demo.people.creditcard.bad;

public class AccountSystemException extends Exception {

    public AccountSystemException() {
        super("El ssitema tiene muchos pedidos y no puede responder");
    }

}
