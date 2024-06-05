package edu.depaul;

public class MockPaymentGateway implements PaymentGateway {

    @Override
    public void processPayment(Order order) {
        // Simulate payment processing
        System.out.println("Processing payment for amount: $" + order);
    }
}
