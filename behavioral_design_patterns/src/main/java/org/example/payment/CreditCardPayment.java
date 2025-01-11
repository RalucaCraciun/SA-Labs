
package org.example.payment;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid payment amount.");
            return;
        }

        // Simulate card validation and payment authorization
        System.out.println("Validating credit card details...");
        boolean isCardValid = true; // Simulating card validation (you can add your own logic here)

        if (isCardValid) {
            // Simulate successful payment
            System.out.println("Payment of $" + amount + " has been successfully processed using Credit Card.");
        } else {
            System.out.println("Payment failed: Invalid credit card details.");
        }
    }
}
