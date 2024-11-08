package com.pluralsight.Classes;


public abstract class OrderItem {
    protected String name;  // The name of the item (e.g., "Sandwich", "Drink", "Chips")
    protected double price;  // The price of the item

    // Constructor to initialize common properties
    public OrderItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Abstract method to be implemented by subclasses to calculate the price
    public abstract double calculatePrice();

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for price
    public double getPrice() {
        return price;
    }

    // Abstract toString method to be implemented by subclasses to display the item details
    @Override
    public abstract String toString();
}

