package edu.depaul;

import java.util.HashMap;
import java.util.ArrayList;

public class ProductCatalog {
    private HashMap<ProductType, ArrayList<Product>> products;

    public ProductCatalog() {
        this.products = new HashMap<>();
        
     // Initialize empty lists for all product types LISTED BELOW
        for (ProductType type : ProductType.values()) {
            products.put(type, new ArrayList<>());
        }

        //ADD PRODUCT 
        addProduct(ProductType.CLOTHES, "Shirts", 15.99, "M");
        addProduct(ProductType.CLOTHES, "hoodies", 22.99, "L");
        addProduct(ProductType.CLOTHES, "Jeans", 20.99, "10");
        addProduct(ProductType.CLOTHES, "Shorts", 9.99, "M");
        addProduct(ProductType.CLOTHES, "Jackets", 25.99, "XL");
        addProduct(ProductType.ELECTRONICS, "Laptop", 799.99, "HP");
        addProduct(ProductType.ELECTRONICS, "Mouse", 99.99, "Logitech");
        addProduct(ProductType.ELECTRONICS, "Keyboard", 199.99, "Logitech");
        addProduct(ProductType.ELECTRONICS, "Headphones", 49.99, "sony");
        addProduct(ProductType.ELECTRONICS, "Portable Speaker", 799.99, "JBL");
        addProduct(ProductType.BEAUTY, "Moisturizer", 24.50, "Ccetaphil");
        addProduct(ProductType.BEAUTY, "Foundation", 14.99, "Milani");
        addProduct(ProductType.BEAUTY, "Lipstick", 8.50, "L’Oréal Paris");
        addProduct(ProductType.BEAUTY, "Mascara", 9.99, "Maybelline");
        addProduct(ProductType.BEAUTY, "Sunscreen", 12.50, "Neutrogena");
        addProduct(ProductType.FURNITURE, "Sofa", 499.99, "Furniwell");
        addProduct(ProductType.FURNITURE, "Book Case", 89.99, "LEYAOYAO");
        addProduct(ProductType.FURNITURE, "Computer Desk", 239.99, "FLEXISPOT");
        addProduct(ProductType.FURNITURE, "Bed Frame", 199.99, "ANCTOR ");
        addProduct(ProductType.FURNITURE, "Dresser", 248.99, "Atlin Designs");
    }

    public void addProduct(ProductType type, String name, double price, String additionalInfo) {
        Product product = ProductFactory.createProduct(type, name, price, additionalInfo);
        products.get(type).add(product);
    }

    public ArrayList<Product> getProducts(ProductType type) {
        if (!products.containsKey(type)) {
            products.put(type, new ArrayList<>()); // Initialize empty list for the product type
        }
        return products.get(type);
    }
}