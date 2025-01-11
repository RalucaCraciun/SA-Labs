
package org.example.handler;

import org.example.Order;

public class PaymentValidationHandler extends OrderValidationHandler {
    @Override
    public void validate(Order order) {
        if (order.getTotalAmount() <= 0) {
            System.out.println("Payment validation failed: Invalid payment amount.");
            throw new IllegalArgumentException("Payment amount must be greater than zero.");
        }
        System.out.println("Payment validation passed.");
        super.validate(order);
    }
}
