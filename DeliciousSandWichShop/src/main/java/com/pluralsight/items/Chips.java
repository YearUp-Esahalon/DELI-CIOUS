package com.pluralsight.items;


import com.pluralsight.Classes.OrderItem;

public class Chips extends OrderItem {
    private String type;

    public Chips(String type) {
        super("Chips", 0.0);  // Default price, will be calculated later
        this.type = type;
    }

    @Override
    public double calculatePrice() {
        return 1.50;  // Chips always cost the same
    }

    @Override
    public String toString() {
        return "Chips: " + type;
    }
}


