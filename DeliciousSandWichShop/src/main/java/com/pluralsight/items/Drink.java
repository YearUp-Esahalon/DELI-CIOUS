package com.pluralsight.items;

import com.pluralsight.Classes.OrderItem;

public class Drink extends OrderItem {
    private String size;
    private String flavor;

    public Drink(String size, String flavor) {
        super("Drink", 0.0);  // Default price, will be calculated later
        this.size = size;
        this.flavor = flavor;
    }

    @Override
    public double calculatePrice() {
        double price = 0.0;

        if (size.equals("Small")) {
            price = 1.50;
        } else if (size.equals("Medium")) {
            price = 2.50;
        } else if (size.equals("Large")) {
            price = 3.50;
        }

        return price;
    }

    @Override
    public String toString() {
        return "Drink: " + flavor + ", Size: " + size;
    }
}

