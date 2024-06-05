package edu.depaul;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CartManager {

    private Cart cart;
    private OrderProcessor orderProcessor;
    
    public CartManager(OrderProcessor orderProcessor) {
        this.cart = new Cart();
        this.orderProcessor = orderProcessor;
    }

    public void addItem(Product product) {
        cart.addItem(product);
    }

    public void removeItem(Product product) {
        if (cart != null) {
            cart.getItems().removeIf(item -> item.getName().equals(product.getName()));
        }
    }
    public void clearCart() {
        cart.clearCart();
    }
    public Cart getCart() {
        return this.cart;
    }

    public void viewCart() {
        if (cart.getItems().isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("\nYour Cart:");
            for (Product item : cart.getItems()) {
                System.out.println("- " + item.getName() + ": $" + item.getPrice());
            }
            System.out.println("Total: $" + calculateTotal(cart.getItems()));
         // Prompt user to place order
            System.out.println("\nWould you like to place your order? (Y/N)");
            Scanner scanner = new Scanner(System.in);
            String response = scanner.nextLine().toUpperCase();
            if (response.equals("Y")) {
                System.out.println("Please provide your full name:");
                String customerName = scanner.nextLine();
                System.out.println("Please provide your shipping address:");
                String customerAddress = scanner.nextLine();
             // Prompt user to enter their card details
                System.out.println("Please enter your card details:");
                String cardDetails = scanner.nextLine();
                createOrder(customerName, customerAddress);
            }
        }
    }

    private double calculateTotal(List<Product> items) {
        double total = 0.0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }
    public void createOrder(String customerName, String customerAddress) {
        Order order = new Order();
        order.setCustomerName(customerName);
        order.setCustomerAddress(customerAddress);
        for (Product item : cart.getItems()) {
            order.addItem(item);
        }
        orderProcessor.placeOrder(order);
        cart.clearCart();
    }
}
