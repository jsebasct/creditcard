package org.demo.people.creditcard.bad;

public class DataBaseLockException extends Exception {

    public DataBaseLockException() {
        super("La base de datos no permite escribir el nuevo cliente");
    }

}
