package org.demo.people.creditcard.domain;

import org.demo.people.creditcard.bad.AccountSystemException;
import org.demo.people.creditcard.bad.CreditCardDestinationException;
import org.demo.people.creditcard.bad.DataBaseLockException;
import org.demo.people.creditcard.bad.MalFunctionPrinterException;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

public class Cobranza {

    private Random random;
    private Deque<String> stack;

    public Cobranza() {
        random = new Random();
        stack = new ArrayDeque<String>();
    }

    private boolean getRandomBoolean() {
        return random.nextBoolean();
    }

    public void cobrar() throws MalFunctionPrinterException, CreditCardDestinationException,
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

        stack.addFirst("IMPRIMIR_FACTURA");
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

        stack.addFirst("ENVIAR_INFO_TC");
        System.out.println("Termno de Enviar Info TC");
    }

    private void informarPago() throws AccountSystemException {

        System.out.println("Comenzando Informar Pago");

        if (getRandomBoolean()) {
            throw new AccountSystemException();
        }

        stack.addFirst("INFORMAR_PAGO");
        System.out.println("Terminando Informar Pago");
    }

    private void actualizarSaldo(String cliente) throws DataBaseLockException {
        System.out.println("actualizando saldo del Cliente:"  + cliente );

        if (getRandomBoolean()) {
            throw new DataBaseLockException();
        }

        stack.addFirst("ACTUALIZAR_SALDO");
        System.out.println("termino de actualizar saldo del Cliente"  );

    }

    private void rollback() {
        if (!stack.isEmpty()) {
            String op = stack.pop();
            System.out.println("Rollback operation: " + op);
            rollback();
        }
    }


    public static void main(String[] args)  {

        Cobranza cobranza = new Cobranza();

        try {
            cobranza.cobrar();
        } catch (MalFunctionPrinterException | CreditCardDestinationException | AccountSystemException | DataBaseLockException e) {
            e.printStackTrace();
            cobranza.rollback();
        }
    }



}
