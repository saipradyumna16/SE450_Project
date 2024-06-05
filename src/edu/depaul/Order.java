package edu.depaul;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> items;
    private String customerName;
    private String customerAddress;

    public Order() {
        this.items = new ArrayList<>();
    }

    public void addItem(Product product) {
        items.add(product);
    }

    public void removeItem(Product product) {
        items.remove(product);
    }

    public List<Product> getItems() {
        return items;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\nCUSTOMER NAME: ").append(customerName).append("\n");
        sb.append("SHIPPING ADDRESS: ").append(customerAddress).append("\n");
        sb.append("\nItems:\n");
        for (Product item : items) {
            sb.append("- ").append(item.getName()).append(": $").append(item.getPrice()).append("\n");
        }
        System.out.println("\nOrder placed successfully! Your order will be delivered in 2 business days.\n\nThank you for shopping!");

        return sb.toString();
    }
}

