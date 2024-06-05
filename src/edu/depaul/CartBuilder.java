package edu.depaul;

import java.util.ArrayList;
import java.util.List;

public class CartBuilder {
    private List<Product> items;
    private String customerName;
    private String customerAddress;

    public CartBuilder() {
        this.items = new ArrayList<>();
    }

    public CartBuilder addItem(Product product) {
        items.add(product);
        return this;
    }

    public CartBuilder removeItem(Product product) {
        items.remove(product);
        return this;
    }

    public CartBuilder setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public CartBuilder setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
        return this;
    }

    public Cart build() {
        return new Cart(items, customerName, customerAddress);
    }
}