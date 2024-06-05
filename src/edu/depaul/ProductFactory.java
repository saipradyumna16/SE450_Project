package edu.depaul;

public class ProductFactory {

    public static Product createProduct(ProductType type, String name, double price, String additionalInfo) {
        switch (type) {
            case CLOTHES:
                return new Clothes(name, price, additionalInfo);
            case ELECTRONICS:
                return new Electronics(name, price, additionalInfo);
            case BEAUTY:
                return new Beauty(name, price, additionalInfo);
            case FURNITURE:
                return new Furniture(name, price, additionalInfo);
            default:
                throw new IllegalArgumentException("Invalid product type");
        }
    }
}
