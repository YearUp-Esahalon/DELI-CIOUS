package com.pluralsight.util;

import com.pluralsight.Classes.Order;
import com.pluralsight.items.Sandwich;
import com.pluralsight.items.Chips;
import com.pluralsight.items.Drink;
import java.util.Scanner;

public class UserInterface {
    private static Scanner scanner = new Scanner(System.in);
    private static Order currentOrder = new Order();

    public static void main(String[] args) {
        displayHomeScreen();
    }

    // Home screen that offers the user a choice
    public static void displayHomeScreen() {
        System.out.println("Welcome to DELI-CIOUS Sandwich Shop!");
        System.out.println("1. New Order");
        System.out.println("0. Exit");
        int choice = getUserChoice();

        if (choice == 1) {
            startNewOrder();
        } else if (choice == 0) {
            System.out.println("Goodbye!");
            System.exit(0);
        } else {
            System.out.println("Invalid choice, please try again.");
            displayHomeScreen();
        }
    }

    // Start a new order (clear the old order and create a new one)
    public static void startNewOrder() {
        currentOrder = new Order();  // Reset the order
        displayOrderScreen();
    }

    // Main order screen
    public static void displayOrderScreen() {
        System.out.println("Current Order:");
        System.out.println(currentOrder);
        System.out.println("1. Add Sandwich");
        System.out.println("2. Add Drink");
        System.out.println("3. Add Chips");
        System.out.println("4. Checkout");
        System.out.println("0. Cancel Order");
        int choice = getUserChoice();

        switch (choice) {
            case 1:
                addSandwich();
                break;
            case 2:
                addDrink();
                break;
            case 3:
                addChips();
                break;
            case 4:
                checkout();
                break;
            case 0:
                cancelOrder();
                break;
            default:
                System.out.println("Invalid choice, please try again.");
                displayOrderScreen();
                break;
        }
    }

    // Method to add a sandwich to the order
    public static void addSandwich() {
        Sandwich sandwich = createSandwich();  // Create a sandwich using the method
        currentOrder.addItem(sandwich);  // Add the sandwich to the order
        System.out.println("Your sandwich has been added.");
        displayOrderScreen();  // Return to the order screen after adding the sandwich
    }

    // Method to create a sandwich by prompting the user for details
    public static Sandwich createSandwich() {
        System.out.println("Select bread type:");
        System.out.println("1. White\n2. Wheat\n3. Rye\n4. Wrap");
        int breadChoice = getUserChoice();
        String bread = "";
        switch (breadChoice) {
            case 1:
                bread = "White";
                break;
            case 2:
                bread = "Wheat";
                break;
            case 3:
                bread = "Rye";
                break;
            case 4:
                bread = "Wrap";
                break;
            default:
                bread = "White";
                break;
        }

        System.out.println("Select sandwich size:");
        System.out.println("1. 4\" ($5.50)\n2. 8\" ($7.00)\n3. 12\" ($8.50)");
        int sizeChoice = getUserChoice();
        String size = "";
        switch (sizeChoice) {
            case 1:
                size = "4\"";
                break;
            case 2:
                size = "8\"";
                break;
            case 3:
                size = "12\"";
                break;
            default:
                size = "8\"";
                break;
        }

        // Meat selection
        System.out.println("Select your meat:");
        System.out.println("1. Turkey\n2. Chicken\n3. Ham\n4. Roast Beef\n5. Veggie");
        int meatChoice = getUserChoice();
        String meat = "";
        switch (meatChoice) {
            case 1:
                meat = "Turkey";
                break;
            case 2:
                meat = "Chicken";
                break;
            case 3:
                meat = "Ham";
                break;
            case 4:
                meat = "Roast Beef";
                break;
            case 5:
                meat = "Veggie";
                break;
            default:
                meat = "Turkey";
                break;
        }

        // Toasted option
        System.out.println("Do you want your sandwich toasted?");
        System.out.println("1. Yes\n2. No");
        int toastedChoice = getUserChoice();
        boolean toasted = (toastedChoice == 1);

        Sandwich sandwich = new Sandwich(size, bread, meat, toasted);
        addToppings(sandwich);
        return sandwich;
    }

    // Allow the user to add toppings to the sandwich
    public static void addToppings(Sandwich sandwich) {
        System.out.println("Select toppings (press 0 to stop):");
        System.out.println("1. Cheese\n2. Lettuce\n3. Tomato\n4. Pickles\n5. Onion");
        int toppingChoice;
        while ((toppingChoice = getUserChoice()) != 0) {
            switch (toppingChoice) {
                case 1:
                    sandwich.addTopping("Cheese");
                    break;
                case 2:
                    sandwich.addTopping("Lettuce");
                    break;
                case 3:
                    sandwich.addTopping("Tomato");
                    break;
                case 4:
                    sandwich.addTopping("Pickles");
                    break;
                case 5:
                    sandwich.addTopping("Onion");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
            System.out.println("Add another topping or press 0 to stop.");
        }
    }

    // Method to add a drink to the order
    public static void addDrink() {
        System.out.println("Select drink size:");
        System.out.println("1. Small\n2. Medium\n3. Large");
        int sizeChoice = getUserChoice();
        String size = "";
        switch (sizeChoice) {
            case 1:
                size = "Small";
                break;
            case 2:
                size = "Medium";
                break;
            case 3:
                size = "Large";
                break;
            default:
                size = "Medium";
                break;
        }

        System.out.println("Select flavor:");
        System.out.println("1. Cola\n2. Lemonade\n3. Water");
        int flavorChoice = getUserChoice();
        String flavor = "";
        switch (flavorChoice) {
            case 1:
                flavor = "Cola";
                break;
            case 2:
                flavor = "Lemonade";
                break;
            case 3:
                flavor = "Water";
                break;
            default:
                flavor = "Cola";
                break;
        }

        Drink drink = new Drink(size, flavor);
        currentOrder.addItem(drink);
        System.out.println("Your drink has been added.");
        displayOrderScreen();
    }

    // Method to add chips to the order
    public static void addChips() {
        System.out.println("Select chip type:");
        System.out.println("1. Plain\n2. Salted\n3. BBQ");
        int chipChoice = getUserChoice();
        String chipType = "";
        switch (chipChoice) {
            case 1:
                chipType = "Plain";
                break;
            case 2:
                chipType = "Salted";
                break;
            case 3:
                chipType = "BBQ";
                break;
            default:
                chipType = "Plain";
                break;
        }

        Chips chips = new Chips(chipType);
        currentOrder.addItem(chips);
        System.out.println("Your chips have been added.");
        displayOrderScreen();
    }

    // Method to display the checkout screen
    public static void checkout() {
        System.out.println("Your order has been placed!");
        System.out.println(currentOrder);
    }

    // Method to cancel the current order
    public static void cancelOrder() {
        currentOrder = new Order(); // Clear the current order
        System.out.println("Your order has been canceled.");
        displayHomeScreen();
    }

    // Utility method to get user input
    public static int getUserChoice() {
        return scanner.nextInt();
    }
}
