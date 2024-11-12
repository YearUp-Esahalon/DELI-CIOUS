package com.pluralsight.Classes;

import com.pluralsight.items.Sandwich;
import com.pluralsight.items.Chips;
import com.pluralsight.items.Drink;
import java.util.ArrayList;

public class Order {
    private ArrayList<OrderItem> items;  // List to store the order items (Sandwiches, Chips, Drinks)

    // Constructor to initialize the order with an empty list
    public Order() {
        items = new ArrayList<>();
    }

    // Method to add an item (Sandwich, Chips, Drink) to the order
    public void addItem(OrderItem item) {
        items.add(item);
    }

    // Calculate the total price of the order
    public double calculateTotal() {
        double total = 0.0;
        for (OrderItem item : items) {
            total += item.calculatePrice(); // Calls the specific item's calculatePrice method
        }
        return total;
    }

    // Method to return a summary of the order
    @Override
    public String toString() {
        StringBuilder orderSummary = new StringBuilder();
        orderSummary.append("Your Order:\n");
        for (OrderItem item : items) {
            orderSummary.append(item.toString()).append("\n"); // Prints each item's details
        }
        orderSummary.append("Total: $").append(calculateTotal()); // Adds the total price
        return orderSummary.toString();
    }

    // Getter for the items list 
    public ArrayList<OrderItem> getItems() {
        return items;
    }
}
