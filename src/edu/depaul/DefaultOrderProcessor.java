package edu.depaul;

public class DefaultOrderProcessor implements OrderProcessor {

    @Override
    public void placeOrder(Order order) {
    	
        System.out.println("\nYour order summary:\n" + order);
       
    }
}