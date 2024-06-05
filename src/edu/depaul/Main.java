package edu.depaul;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import edu.depaul.OrderProcessor;
import edu.depaul.PaymentGateway;

public class Main {

    static HashMap<String, String> users = new HashMap<String, String>();
    static ProductCatalog catalog = new ProductCatalog();
    static OrderProcessor orderProcessor = new DefaultOrderProcessor();
    static CartManager cartManager = new CartManager(orderProcessor);
    static PaymentGateway paymentGateway = new MockPaymentGateway();
    

    Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 3) {
            System.out.println("Select an option: ");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Quit");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    if(loginUser(scanner));
                    {
                    	break;
                    }
                    
                case 3:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        scanner.close();
    }

    static void registerUser(Scanner scanner) {
        System.out.println("Enter your username:");
        String username = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();
        if (users.containsKey(username)) {
            System.out.println("User already exists.");
        } else {
            users.put(username, password);
            System.out.println("Registration successful.");
        }
    }

    static boolean loginUser(Scanner scanner) {
        System.out.println("Enter your username:");
        String username = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();
        
        if (!users.containsKey(username)) {
            System.out.println("Invalid username or password.");
            return false;
        } else {
            if (users.get(username).equals(password)) {
                System.out.println("Login successful.");
                browseCatalog(username);
                return true;
            } else {
                System.out.println("Invalid username or password.");
                return false;
            }
        }}
        static void browseCatalog(String username) {
        	int choice=0;
        	CartBuilder cartBuilder = new CartBuilder();
        	while(choice!=5) {
            System.out.println("\nWelcome to the Product Catalog!");
            System.out.println("1. Clothes");
            System.out.println("2. Electronics");
            System.out.println("3. Beauty");
            System.out.println("4. Furniture");
            System.out.println("5. Back to Menu");
            System.out.println("6. VIEW CART");

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayProducts(ProductType.CLOTHES);
                    addToCartOrRemoveFromCart(cartManager, scanner,ProductType.CLOTHES);
                    
                    break;
                case 2:
                    displayProducts(ProductType.ELECTRONICS);
                    addToCartOrRemoveFromCart(cartManager, scanner, ProductType.ELECTRONICS);
                    
                    break;
                case 3:
                    displayProducts(ProductType.BEAUTY);
                    addToCartOrRemoveFromCart(cartManager, scanner,ProductType.BEAUTY);
                    
                    break;
                case 4:
                    displayProducts(ProductType.FURNITURE);
                    addToCartOrRemoveFromCart(cartManager, scanner,ProductType.FURNITURE);
                    
                    break;
                case 5:
                    // Back to menu
                    break;
                case 6:
                    cartManager.viewCart();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        	
        	// Place order
            System.out.println("\nWould you like to place your order? (Y/N)");
            Scanner scanner = new Scanner(System.in);
            String response = scanner.nextLine().toUpperCase();
            if (response.equals("Y")) {
                System.out.println("Please provide your full name:");
                String customerName = scanner.nextLine();
                System.out.println("Please provide your shipping address:");
                String customerAddress = scanner.nextLine();
                Cart cart = cartBuilder.setCustomerName(customerName)
                                        .setCustomerAddress(customerAddress)
                                        .build();
                System.out.println("\n\nOrder placed successfully!");
                System.out.println("\nOrder details:\n");
                System.out.println(cart);
            }
        }

        static void addToCartOrRemoveFromCart(CartManager cartManager, Scanner scanner, ProductType type) {
            System.out.println("\nWould you like to add or remove an item from your cart? (A/R/N)");
            ProductCatalog catalog = new ProductCatalog(); // Create an instance of ProductCatalog
            List<Product> products = catalog.getProducts(type); // Retrieve products of the given type
            String choice = scanner.nextLine().toUpperCase();
            
            if (!cartManager.getCart().getItems().isEmpty() && choice.equals("N")) {
                System.out.println("Would you like to place your order? (Y/N)");
                String response = scanner.nextLine().toUpperCase();
                if (response.equals("Y")) {
                    // Prompt user to enter user name
                    System.out.println("Please provide your full name:");
                    String customerName = scanner.nextLine();

                    // Prompt user to enter user address
                    System.out.println("Please provide the full shipping address:");
                    String customerAddress = scanner.nextLine();

                    // Call createOrder with the provided user name and address
                    cartManager.createOrder(customerName, customerAddress);
                }
            }
            
            switch (choice) {
                case "A":
                    System.out.println("Enter the name of the product to add:");
                    String productName = scanner.nextLine();
                    Product productToAdd = findProductByName(products, productName);
                    if (productToAdd != null) {
                        cartManager.addItem(productToAdd);
                        System.out.println(productName + " added to cart.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case "R":
                    System.out.println("Enter the name of the product to remove:");
                    String productToRemoveName = scanner.nextLine();
                    Product productToRemove = findProductByName(products, productToRemoveName);
                    if (productToRemove != null) {
                        cartManager.removeItem(productToRemove);
                        System.out.println(productToRemoveName + " removed from cart.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case "N":
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
            
        
        }


        static Product findProductByName(List<Product> products, String name) {
            for (Product product : products) {
                if (product.getName().equalsIgnoreCase(name)) {
                    return product;
                }
            }
            return null;
        }

        static void displayProducts(ProductType type) {
            for (Product product : catalog.getProducts(type)) {
            	// Display product details
                System.out.println(product.toString());             }
        }
}
	