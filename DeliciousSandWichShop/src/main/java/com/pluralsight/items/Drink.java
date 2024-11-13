package com.pluralsight.items;

import com.pluralsight.Classes.OrderItem;

public class Drink extends OrderItem {

    private String size;   // Size of the drink (Small, Medium, Large)
    private String flavor;
    private double price;
    // Flavor of the drink (Cola, Lemonade, Water)

    public Drink(String size, String flavor) {
        super("Drink", 2.50); // Default price for drinks (this is a fallback)
        this.size = size;
        this.flavor = flavor;
        setPriceBasedOnSize(size); // Set price based on size
    }

    // Set price based on drink size
    public void setPriceBasedOnSize(String size) {
        if (size.equals("Small")) {
            this.price = 2.00;
        } else if (size.equals("Medium")) {
            this.price = 2.50;
        } else if (size.equals("Large")) {
            this.price = 3.00;
        }
    }

    @Override
    public double calculatePrice() {
        return price;  // Return the set price based on size
    }

    @Override
    public String toString() {
        return super.toString() + "\nSize: " + size + "\nFlavor: " + flavor + "\nPrice: $" + calculatePrice();
    }

    // Getters and setters for the fields
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
        setPriceBasedOnSize(size); // Update price when size changes
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
}
