package org.example;

import org.example.handler.InventoryCheckHandler;
import org.example.handler.OrderValidationHandler;
import org.example.handler.PaymentValidationHandler;
import org.example.payment.CreditCardPayment;
import org.example.payment.PaymentStrategy;

public class Main {
    public static void main(String[] args) {
        Order order = new Order(1L, "John Doe", "Processing", 150.0);

        PaymentStrategy payment = new CreditCardPayment();

        payment.pay(order.getTotalAmount());

        OrderValidationHandler inventoryCheckHandler = new InventoryCheckHandler();
        OrderValidationHandler paymentValidationHandler = new PaymentValidationHandler();

        inventoryCheckHandler.setNext(paymentValidationHandler);

        inventoryCheckHandler.validate(order);

    }
}