package edu.depaul;
public abstract class AbstractProduct implements Product {

    private String name;
    protected double price;

    public AbstractProduct(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public abstract double getPrice(); // Abstract method 

    @Override
    public String toString() {
        return "Product: " + name + ", Price: $" + price; // tostring to display content
    }
}
