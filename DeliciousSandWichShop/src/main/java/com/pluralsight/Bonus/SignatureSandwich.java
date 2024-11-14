package com.pluralsight.Bonus;

import com.pluralsight.items.Sandwich;

public class SignatureSandwich extends Sandwich {

    // Constructor to initialize Signature Sandwich with name and size
    public SignatureSandwich(String name, String size) {
        super(size, "White", "", false);  // Call the parent constructor with default values

        setName(name);  // Set the name for the signature sandwich

        // Set predefined ingredients based on the sandwich name
        switch (name) {
            case "BLT":
                setMeat("Bacon");
                addTopping("Cheddar");
                addTopping("Lettuce");
                addTopping("Tomato");
                addTopping("Ranch");
                setToasted(true);  // Default toasted for BLT
                break;

            case "Philly Cheese Steak":
                setMeat("Steak");
                addTopping("American Cheese");
                addTopping("Peppers");
                addTopping("Mayo");
                setToasted(true);  // Default toasted for Philly Cheese Steak
                break;

            // You can add more signature sandwiches here
            default:
                break;
        }
    }

    // Override toString() method to provide a detailed description of the signature sandwich
    @Override
    public String toString() {
        StringBuilder sandwichDescription = new StringBuilder();
        sandwichDescription.append(getName()).append(" - ").append(getSize()).append(" ")
                .append(getBreadType()).append(" bread, ").append(getMeat()).append(" meat, ")
                .append(isToasted() ? "Toasted" : "Not Toasted").append("\n");

        // Adding default toppings
        sandwichDescription.append("Toppings: ");
        for (String topping : getToppings()) {
            sandwichDescription.append(topping).append(" ");
        }

        return sandwichDescription.toString().trim();
    }
}

