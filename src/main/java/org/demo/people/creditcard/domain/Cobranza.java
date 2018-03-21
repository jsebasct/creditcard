package org.demo.people.creditcard.domain;

import org.demo.people.creditcard.bad.AccountSystemException;
import org.demo.people.creditcard.bad.CreditCardDestinationException;
import org.demo.people.creditcard.bad.MalFunctionPrinterException;
import org.demo.people.creditcard.bad.DataBaseLockException;

import java.util.Random;

public class Cobranza {

    Random random = new Random();

    private boolean getRandomBoolean() {
        return random.nextBoolean();
    }

    public void cobrar() throws MalFunctionPrinterException,
            CreditCardDestinationException,
            AccountSystemException, DataBaseLockException {

        imprimirFactura();
        enviarInfoTC();
        informarPago();
        actualizarSaldo("cliente");
    }

    private void imprimirFactura() throws MalFunctionPrinterException {
        System.out.println("Imprimendo Factura");

        if (getRandomBoolean()) {
            throw new MalFunctionPrinterException();
        }

        System.out.println("Termino de Imprimir Factura");
    }

    /**
     * Enviar informacion de la tarjeta de credito
     */
    private void enviarInfoTC() throws CreditCardDestinationException {

        System.out.println("Comenzando a enviar Info TC");

        if (getRandomBoolean()) {
            throw new CreditCardDestinationException();
        }

        System.out.println("Termno de Enviar Info TC");
    }

    private void informarPago() throws AccountSystemException {

        System.out.println("Comenzando Informar Pago");

        if (getRandomBoolean()) {
            throw new AccountSystemException();
        }

        System.out.println("Terminando Informar Pago");
    }

    private void actualizarSaldo(String cliente) throws DataBaseLockException {
        System.out.println("actualizando saldo del Cliente:"  + cliente );

        if (getRandomBoolean()) {
            throw new DataBaseLockException();
        }

        System.out.println("termino de actualizar saldo del Cliente"  );

    }


    public static void main(String[] args) throws Exception {
        new Cobranza().cobrar();
    }

}
