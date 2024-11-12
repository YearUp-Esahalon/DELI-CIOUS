package com.pluralsight.Classes;

public abstract class OrderItem {
    private String name;  // Name of the item (e.g., Sandwich, Chips, Drink)
    private double price;  // Price of the item

    // Constructor to initialize name and price
    public OrderItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getter for the name
    public String getName() {
        return name;
    }

    // Setter for the name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for the price
    public double getPrice() {
        return price;
    }

    // Setter for the price
    public void setPrice(double price) {
        this.price = price;
    }

    // Abstract method to calculate price (this should be implemented by subclasses)
    public abstract double calculatePrice();

    // toString method to represent the item as a string
    @Override
    public String toString() {
        return name + ": $" + price;
    }
}
