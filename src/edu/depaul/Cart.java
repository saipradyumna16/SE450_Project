package edu.depaul;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> items;
    private String customerName;
    private String customerAddress;

    public Cart(List<Product> items, String customerName, String customerAddress) {
        this.items = items;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
    }

    public List<Product> getItems() {
        return items;
    }
    public Cart() {
        this.items = new ArrayList<>();
    }
    public void addItem(Product product) {
        items.add(product);
    }

    public void removeItem(Product product) {
		// TODO Auto-generated method stub
		items.remove(product);
	}

    public void clearCart() {
        items.clear();
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer: ").append(customerName).append("\n");
        sb.append("Address: ").append(customerAddress).append("\n");
        sb.append("Items:\n");
        for (Product item : items) {
            sb.append("- ").append(item.getName()).append(": $").append(item.getPrice()).append("\n");
        }
        return sb.toString();
    }	
}