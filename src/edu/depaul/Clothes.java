package edu.depaul;

//Concrete Product classes (Open/Closed Principle, Liskov Substitution Principle)

public class Clothes extends AbstractProduct {
    private String size;
    private static String categoryHeader = "CLOTHES:\n";

    public Clothes(String name, double price, String size) {
        super(name, price);
        this.size = size;
    }
    public double getPrice() {
        return price; // Assuming 'price' is a field inherited from AbstractProduct
    }
    @Override
    public String toString() {
    	if (!categoryHeader.isEmpty()) {
            System.out.println(categoryHeader);
            categoryHeader = ""; // Clear header after first print
        }
        return getName() + " (Size: " + size + "), Price: $" + getPrice();
    }
}