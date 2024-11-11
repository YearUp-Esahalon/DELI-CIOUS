package com.pluralsight.items;

import com.pluralsight.Classes.OrderItem;

public class Chips extends OrderItem {

    // Constructor that sets the name and price for chips
    public Chips(String chipType) {
        super("Chips", 1.50);  // Chips cost $1.50
    }

    // Override getPrice to return the price of chips (in case you want to change the price in the future)
    @Override
    public double getPrice() {
        return super.getPrice();  // Return the price set by the parent class (1.50)
    }

    @Override
    public double calculatePrice() {
        return 0;
    }

    // Optionally, you can override the toString() method if you'd like a custom string representation
    @Override
    public String toString() {
        return getName() + ": $" + getPrice();  // Example: "Chips: $1.50"
    }

    // No need for a calculatePrice method because the price is fixed in the constructor and inherited from OrderItem
}
