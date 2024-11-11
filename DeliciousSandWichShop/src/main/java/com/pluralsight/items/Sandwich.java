package com.pluralsight.items;

import com.pluralsight.Classes.OrderItem;
import java.util.ArrayList;

public class Sandwich extends OrderItem {
    private String size; // Size of the sandwich (e.g., 4", 8", 12")
    private String breadType; // Type of bread (e.g., White, Wheat, Rye, Wrap)
    private ArrayList<String> toppings = new ArrayList<>(); // List of toppings
    private String meat; // Meat type (e.g., Turkey, Ham, Chicken)
    private boolean toasted; // Whether the sandwich is toasted or not

    // Constructor to initialize the sandwich with size, bread, meat, and toasted option
    public Sandwich(String size, String breadType, String meat, boolean toasted) {
        super("Sandwich", 0);  // Super class "OrderItem", setting default name and price
        this.size = size;
        this.breadType = breadType;
        this.meat = meat;
        this.toasted = toasted;

        // Set the price based on the size of the sandwich
        switch (size) {
            case "4\"":
                setPrice(5.50);
                break;
            case "8\"":
                setPrice(7.00);
                break;
            case "12\"":
                setPrice(8.50);
                break;
            default:
                setPrice(7.00);  // Default to 8" size price
                break;
        }
    }

    // Add a topping to the sandwich
    public void addTopping(String topping) {
        toppings.add(topping);
    }

    // Calculate the total price of the sandwich
    @Override
    public double calculatePrice() {
        double price = getPrice();

        // Charge extra for each topping
        price += toppings.size() * 0.50;  // Each topping costs $0.50

        return price;
    }

    // Overriding toString() method to return a detailed description of the sandwich
    @Override
    public String toString() {
        StringBuilder sandwichDescription = new StringBuilder();
        sandwichDescription.append("Sandwich: ").append(size).append(" ").append(breadType).append(" bread, ")
                .append(meat).append(" meat, ").append(toasted ? "Toasted" : "Not Toasted").append("\n");
        sandwichDescription.append("Toppings: ");
        for (String topping : toppings) {
            sandwichDescription.append(topping).append(" ");
        }
        return sandwichDescription.toString().trim();
    }

    // Getters and setters for the fields
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public ArrayList<String> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<String> toppings) {
        this.toppings = toppings;
    }

    public String getMeat() {
        return meat;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }
}

