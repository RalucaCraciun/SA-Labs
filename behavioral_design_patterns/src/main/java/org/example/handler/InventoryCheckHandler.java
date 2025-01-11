
package org.example.handler;

import org.example.Order;

public class InventoryCheckHandler extends OrderValidationHandler {
    @Override
    public void validate(Order order) {
        int quantityNeeded = 1; // Example quantity needed for the order

        int availableStock= 5;
        if (availableStock >= quantityNeeded) {
            System.out.println("Inventory check passed. Stock available: " + availableStock);
            super.validate(order);
        } else {
            System.out.println("Inventory check failed. Not enough stock.");
            throw new RuntimeException("Not enough stock available.");
        }
    }
}
