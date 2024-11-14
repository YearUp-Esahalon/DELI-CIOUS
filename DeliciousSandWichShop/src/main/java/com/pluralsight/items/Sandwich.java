package com.pluralsight.items;

import com.pluralsight.OrderClasses.OrderItem;
import java.util.ArrayList;

public class Sandwich extends OrderItem {
    private String size; // Size of the sandwich (e.g., 4", 8", 12")
    private String breadType; // Type of bread (e.g., White, Wheat, Rye, Wrap)
    private ArrayList<String> toppings = new ArrayList<>(); // List of toppings
    private String meat; // Meat type (e.g., Turkey, Ham, Chicken)
    private boolean toasted; // Whether the sandwich is toasted or not
    private String cheese; // Cheese type
    private boolean extraCheese; // Whether extra cheese is selected
    private boolean extraMeat; // Whether extra meat is selected

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

    // Set cheese type for the sandwich
    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    // Add extra cheese
    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    // Add extra meat
    public void setExtraMeat(boolean extraMeat) {
        this.extraMeat = extraMeat;
    }

    // Calculate the total price of the sandwich (including meat, cheese, toppings, etc.)
    @Override
    public double calculatePrice() {
        double price = getPrice();

        // Charge extra for meat based on sandwich size
        double meatPrice = 0.0;
        switch (size) {
            case "4\"":
                meatPrice = 1.00;
                break;
            case "8\"":
                meatPrice = 2.00;
                break;
            case "12\"":
                meatPrice = 3.00;
                break;
        }
        price += meatPrice;

        // Charge for extra meat
        if (extraMeat) {
            switch (size) {
                case "4\"":
                    price += 0.50;
                    break;
                case "8\"":
                    price += 1.00;
                    break;
                case "12\"":
                    price += 1.50;
                    break;
            }
        }

        // Charge for cheese based on sandwich size
        double cheesePrice = 0.0;
        if (cheese != null) {
            switch (size) {
                case "4\"":
                    cheesePrice = 0.75;
                    break;
                case "8\"":
                    cheesePrice = 1.50;
                    break;
                case "12\"":
                    cheesePrice = 2.25;
                    break;
            }
            price += cheesePrice;
        }

        // Charge for extra cheese
        if (extraCheese) {
            switch (size) {
                case "4\"":
                    price += 0.30;
                    break;
                case "8\"":
                    price += 0.60;
                    break;
                case "12\"":
                    price += 0.90;
                    break;
            }
        }

        return price;
    }

    // Overriding toString() method to return a detailed description of the sandwich
    @Override
    public String toString() {
        StringBuilder sandwichDescription = new StringBuilder();
        sandwichDescription.append("Sandwich: ").append(size).append(" ").append(breadType).append(" bread, ")
                .append(meat).append(" meat, ").append(toasted ? "Toasted" : "Not Toasted").append("\n");

        if (cheese != null) {
            sandwichDescription.append("Cheese: ").append(cheese).append("\n");
        }

        if (extraCheese) {
            sandwichDescription.append("Extra Cheese: Yes\n");
        }

        if (extraMeat) {
            sandwichDescription.append("Extra Meat: Yes\n");
        }

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

    // SignatureSandwich subclass
    public static class SignatureSandwich extends Sandwich {
        // Constructor for Signature Sandwich that sets predefined values
        public SignatureSandwich(String size, boolean toasted) {
            super(size, "White", "Bacon", toasted);  // Default to White bread, Bacon meat
            setCheese("Cheddar");  // Default cheese for Signature BLT
            addTopping("Lettuce");
            addTopping("Tomato");
            addTopping("Ranch");
        }

        // Custom toString() for Signature Sandwich
        @Override
        public String toString() {
            return "Signature Sandwich (BLT): " + super.toString();
        }
    }
}
