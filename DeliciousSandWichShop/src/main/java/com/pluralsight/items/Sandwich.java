package com.pluralsight.items;



import com.pluralsight.Classes.OrderItem;

import java.util.ArrayList;

public class Sandwich extends OrderItem {
    private String size;
    private String bread;
    private ArrayList<String> toppings;
    private boolean toasted;

    public Sandwich(String size, String bread) {
        super("Sandwich", 0.0);  // Default price, will be calculated later
        this.size = size;
        this.bread = bread;
        this.toppings = new ArrayList<>();
        this.toasted = false;
    }

    public void addTopping(String topping) {
        toppings.add(topping);
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    @Override
    public double calculatePrice() {
        double price = 0.0;

        // Base price depending on the size
        if (size.equals("4\"")) {
            price = 5.50;
        } else if (size.equals("8\"")) {
            price = 7.00;
        } else if (size.equals("12\"")) {
            price = 8.50;
        }

        // Add cost for premium toppings
        for (String topping : toppings) {
            if (topping.equals("Meat") || topping.equals("Cheese")) {
                price += 1.00;  // Add premium topping cost
            }
        }

        // Add extra cost if toasted
        if (toasted) {
            price += 0.50;
        }

        return price;
    }

    @Override
    public String toString() {
        StringBuilder sandwichDetails = new StringBuilder();
        sandwichDetails.append("Sandwich: " + size + ", Bread: " + bread + ", Toppings: ");

        if (toppings.isEmpty()) {
            sandwichDetails.append("None");
        } else {
            for (String topping : toppings) {
                sandwichDetails.append(topping + " ");
            }
        }

        sandwichDetails.append(", Toasted: " + (toasted ? "Yes" : "No"));

        return sandwichDetails.toString();
    }
}
