package com.pluralsight.util;

import com.pluralsight.Classes.Order;
import com.pluralsight.items.Sandwich;

import java.util.Scanner;

// Main class to handle user interface for the DELI-cious sandwich shop
public class Userinterface {
    private static Scanner scanner = new Scanner(System.in);  // Scanner to read user input
    private static Order currentOrder = new Order();  // Object to store the current order

    // Main method to run the application
    public static void main(String[] args) {
        displayHomeScreen();  // Show the home screen when the program starts
    }

    // Display the Home Screen
    public static void displayHomeScreen() {
        System.out.println("Welcome to DELI-CIOUS Sandwich Shop!");
        System.out.println("Please select an option:");
        System.out.println("1. New Order");
        System.out.println("0. Exit");

        int choice = getUserChoice();

        if (choice == 1) {
            startNewOrder();  // Start a new order
        } else if (choice == 0) {
            System.out.println("Thank you for visiting DELI-cious. Goodbye!");
            System.exit(0);  // Exit the application
        } else {
            System.out.println("Invalid choice, please try again.");
            displayHomeScreen();  // Show the home screen again if the input is invalid
        }
    }

    // Start a new order and navigate to the order screen
    public static void startNewOrder() {
        currentOrder = new Order();  // Reset the order
        displayOrderScreen();  // Show the order screen
    }

    // Display the Order Screen
    public static void displayOrderScreen() {
        System.out.println("\nYour current order:");
        System.out.println("Sandwiches: " + currentOrder.getSandwiches().size());
        System.out.println("Items: " + currentOrder.getItems().size());
        System.out.println("Total Cost: $" + currentOrder.calculateTotal());

        System.out.println("\nOrder Options:");
        System.out.println("1. Add Sandwich");
        System.out.println("2. Add Drink");
        System.out.println("3. Add Chips");
        System.out.println("4. Checkout");
        System.out.println("0. Cancel Order");

        int choice = getUserChoice();

        if (choice == 1) {
            addSandwich();  // Proceed to add sandwich
        } else if (choice == 2) {
            addDrink();  // Proceed to add drink
        } else if (choice == 3) {
            addChips();  // Proceed to add chips
        } else if (choice == 4) {
            checkout();  // Proceed to checkout
        } else if (choice == 0) {
            cancelOrder();  // Cancel the order and return to the home screen
        } else {
            System.out.println("Invalid choice, please try again.");
            displayOrderScreen();  // Show the order screen again if the input is invalid
        }
    }

    // Add a new sandwich to the order
    public static void addSandwich() {
        Sandwich sandwich = createSandwich();  // Create a sandwich using the method
        currentOrder.addSandwich(sandwich);  // Add the sandwich to the order
        System.out.println("Your sandwich has been added.");
        displayOrderScreen();  // Return to the order screen after adding the sandwich
    }

    // Create a sandwich by selecting bread, size, and toppings
    public static Sandwich createSandwich() {
        System.out.println("Select your bread:");
        System.out.println("1. White");
        System.out.println("2. Wheat");
        System.out.println("3. Rye");
        System.out.println("4. Wrap");

        int breadChoice = getUserChoice();
        String bread = "";
        if (breadChoice == 1) {
            bread = "White";
        } else if (breadChoice == 2) {
            bread = "Wheat";
        } else if (breadChoice == 3) {
            bread = "Rye";
        } else if (breadChoice == 4) {
            bread = "Wrap";
        } else {
            bread = "White";  // Default to White bread
        }

        System.out.println("Select sandwich size:");
        System.out.println("1. 4\" ($5.50)");
        System.out.println("2. 8\" ($7.00)");
        System.out.println("3. 12\" ($8.50)");

        int sizeChoice = getUserChoice();
        String size = "";
        if (sizeChoice == 1) {
            size = "4\"";
        } else if (sizeChoice == 2) {
            size = "8\"";
        } else if (sizeChoice == 3) {
            size = "12\"";
        } else {
            size = "8\"";  // Default to 8" sandwich size
        }

        // Creating sandwich object with chosen bread and size
        Sandwich sandwich = new Sandwich(size, bread);

        // Add Meats
        System.out.println("\nSelect meats for your sandwich:");
        System.out.println("1. Turkey");
        System.out.println("2. Ham");
        System.out.println("3. Roast Beef");
        System.out.println("4. Chicken");
        System.out.println("5. Bacon");
        System.out.print("Select meat (comma separated for multiple): ");
        String meatChoice = scanner.nextLine();
        String[] meatSelections = meatChoice.split(",");
        for (String meat : meatSelections) {
            meat = meat.trim();
            if (meat.equalsIgnoreCase("Turkey") || meat.equalsIgnoreCase("Ham") || meat.equalsIgnoreCase("Roast Beef") || meat.equalsIgnoreCase("Chicken") || meat.equalsIgnoreCase("Bacon")) {
                sandwich.addTopping(meat);  // Add valid meat toppings
            }
        }

        // Add Cheeses
        System.out.println("\nSelect cheeses for your sandwich:");
        System.out.println("1. Cheddar");
        System.out.println("2. Swiss");
        System.out.println("3. Provolone");
        System.out.println("4. American");
        System.out.print("Select cheese (comma separated for multiple): ");
        String cheeseChoice = scanner.nextLine();
        String[] cheeseSelections = cheeseChoice.split(",");
        for (String cheese : cheeseSelections) {
            cheese = cheese.trim();
            if (cheese.equalsIgnoreCase("Cheddar") || cheese.equalsIgnoreCase("Swiss") || cheese.equalsIgnoreCase("Provolone") || cheese.equalsIgnoreCase("American")) {
                sandwich.addTopping(cheese);  // Add valid cheese toppings
            }
        }

        // Add Sauces
        System.out.println("\nSelect sauces for your sandwich:");
        System.out.println("1. Mayonnaise");
        System.out.println("2. Mustard");
        System.out.println("3. Ketchup");
        System.out.println("4. Ranch");
        System.out.print("Select sauce (comma separated for multiple): ");
        String sauceChoice = scanner.nextLine();
        String[] sauceSelections = sauceChoice.split(",");
        for (String sauce : sauceSelections) {
            sauce = sauce.trim();
            if (sauce.equalsIgnoreCase("Mayonnaise") || sauce.equalsIgnoreCase("Mustard") || sauce.equalsIgnoreCase("Ketchup") || sauce.equalsIgnoreCase("Ranch")) {
                sandwich.addTopping(sauce);  // Add valid sauce toppings
            }
        }

        // Ask if the sandwich should be toasted
        System.out.print("Would you like your sandwich toasted? (yes/no): ");
        String toastChoice = scanner.nextLine();
        sandwich.setToasted(toastChoice.equalsIgnoreCase("yes"));

        return sandwich;  // Return the newly created sandwich
    }

    // Add a drink to the order
    public static void addDrink() {
        System.out.println("Select drink size:");
        System.out.println("1. Small ($2.00)");
        System.out.println("2. Medium ($2.50)");
        System.out.println("3. Large ($3.00)");

        int sizeChoice = getUserChoice();
        String size = "";
        if (sizeChoice == 1) {
            size = "Small";
        } else if (sizeChoice == 2) {
            size = "Medium";
        } else if (sizeChoice == 3) {
            size = "Large";
        } else {
            size = "Medium";  // Default to Medium
        }

        System.out.println("Select drink flavor:");
        System.out.println("1. Cola");
        System.out.println("2. Lemonade");
        System.out.println("3. Water");

        int flavorChoice = getUserChoice();
        String flavor = "";
        if (flavorChoice == 1) {
            flavor = "Cola";
        } else if (flavorChoice == 2) {
            flavor = "Lemonade";
        } else if (flavorChoice == 3) {
            flavor = "Water";
        } else {
            flavor = "Cola";  // Default to Cola
        }

        // Assuming a method to add drink to order
        currentOrder.addItem("Drink: " + size + " " + flavor);
        System.out.println("Your drink has been added.");
        displayOrderScreen();
    }

    // Add chips to the order
    public static void addChips() {
        System.out.println("Select chip flavor:");
        System.out.println("1. Original");
        System.out.println("2. Barbecue");
        System.out.println("3. Sour Cream & Onion");

        int chipChoice = getUserChoice();
        String flavor = "";
        if (chipChoice == 1) {
            flavor = "Original";
        } else if (chipChoice == 2) {
            flavor = "Barbecue";
        } else if (chipChoice == 3) {
            flavor = "Sour Cream & Onion";
        } else {
            flavor = "Original";  // Default to Original
        }

        // Assuming a method to add chips to order
        currentOrder.addItem("Chips: " + flavor);
        System.out.println("Your chips have been added.");
        displayOrderScreen();
    }

    // Proceed to checkout
    public static void checkout() {
        System.out.println("Proceeding to checkout...");
        System.out.println("Your total is: $" + currentOrder.calculateTotal());
        // Add any other checkout steps here (e.g., payment)
    }

    // Cancel the order
    public static void cancelOrder() {
        System.out.println("Your order has been canceled.");
        displayHomeScreen();  // Return to the home screen after canceling the order
    }

    // Helper method to get user's choice as integer
    public static int getUserChoice() {
        int choice = -1;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            // Handle invalid input
        }
        return choice;
    }
}
