package edu.depaul;

public class Furniture extends AbstractProduct {
    private String material;
    private static String categoryHeader = "FURNITURE:\n";

    public Furniture(String name, double price, String material) {
        super(name, price);
        this.material = material;
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
        return getName() + " (" + material + "), Price: $" + getPrice();
    }
}
