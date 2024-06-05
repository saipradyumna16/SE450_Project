package edu.depaul;

public class Beauty extends AbstractProduct {
    private String type; // e.g., Skincare, Makeup
    private static String categoryHeader = "BEAUTY:\n";

    public Beauty(String name, double price, String type) {
        super(name, price);
        this.type = type;
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
        return getName() + " (" + type + "), Price: $" + getPrice();
    }
    
}
