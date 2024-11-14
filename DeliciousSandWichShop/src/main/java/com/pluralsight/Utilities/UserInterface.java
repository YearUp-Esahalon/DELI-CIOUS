package com.pluralsight.Utilities;

import com.pluralsight.OrderClasses.Order;
import com.pluralsight.items.Sandwich;
import com.pluralsight.items.Chips;
import com.pluralsight.items.Drink;
import com.pluralsight.Bonus.SignatureSandwich;
import java.util.Scanner;

public class UserInterface {
    private static Scanner scanner = new Scanner(System.in);
    private static Order currentOrder = new Order();

    public static void main(String[] args) {
        displayHomeScreen();
    }

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

    public static void startNewOrder() {
        currentOrder = new Order();  // Reset the order
        displayOrderScreen();
    }

    public static void displayOrderScreen() {
        System.out.println("Current Order:");
        System.out.println(currentOrder);// Display the current order (items and details) to the user
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

    public static void addSandwich() {
        System.out.println("Do you want a Signature Sandwich or create a Custom Sandwich?");
        System.out.println("1. Signature Sandwich");
        System.out.println("2. Custom Sandwich");
        int choice = getUserChoice();

        if (choice == 1) {
            addSignatureSandwich();  // Add Signature Sandwich
        } else if (choice == 2) {
            addCustomSandwich();  // Create a Custom Sandwich
        } else {
            System.out.println("Invalid choice, please try again.");
            addSandwich();
        }
    }

    // Method to add Signature Sandwich
    public static void addSignatureSandwich() {
        System.out.println("Select a Signature Sandwich:");
        System.out.println("1. BLT");
        System.out.println("2. Philly Cheese Steak");
        int choice = getUserChoice();

        SignatureSandwich sandwich = null;
        switch (choice) {
            case 1:
                sandwich = new SignatureSandwich("BLT", "8\"");
                break;
            case 2:
                sandwich = new SignatureSandwich("Philly Cheese Steak", "8\"");
                break;
            default:
                System.out.println("Invalid choice, please try again.");
                addSignatureSandwich();
                return;
        }

        currentOrder.addItem(sandwich);
        System.out.println("Your signature sandwich has been added.");
        displayOrderScreen();
    }

    // Method to create a custom sandwich (if the user opts for this)
    public static void addCustomSandwich() {
        Sandwich sandwich = createSandwich();
        currentOrder.addItem(sandwich);
        System.out.println("Your custom sandwich has been added.");
        displayOrderScreen();
    }

    // Modified createSandwich() method to handle custom sandwich creation
    public static Sandwich createSandwich() {
        System.out.println("Select bread type:");
        System.out.println("1. White\n2. Wheat\n3. Rye\n4. Wrap");
        int breadChoice = getUserChoice();
        String bread = switch (breadChoice) {
            case 1 -> "White";
            case 2 -> "Wheat";
            case 3 -> "Rye";
            case 4 -> "Wrap";
            default -> "White";
        };

        System.out.println("Select sandwich size:");
        System.out.println("1. 4\" ($5.50)\n2. 8\" ($7.00)\n3. 12\" ($8.50)");
        int sizeChoice = getUserChoice();
        String size = switch (sizeChoice) {
            case 1 -> "4\"";
            case 2 -> "8\"";
            case 3 -> "12\"";
            default -> "8\"";
        };

        System.out.println("Select your meat:");
        System.out.println("1. Steak\n2. Ham\n3. Salami\n4. Roast Beef\n5. Chicken\n6. Bacon");
        int meatChoice = getUserChoice();
        String meat = switch (meatChoice) {
            case 1 -> "Steak";
            case 2 -> "Ham";
            case 3 -> "Salami";
            case 4 -> "Roast Beef";
            case 5 -> "Chicken";
            case 6 -> "Bacon";
            default -> "Steak";
        };

        System.out.println("Do you want your sandwich toasted?");
        System.out.println("1. Yes\n2. No");
        int toastedChoice = getUserChoice();
        boolean toasted = toastedChoice == 1;

        Sandwich sandwich = new Sandwich(size, bread, meat, toasted);

        // Handle extra meat
        System.out.println("Do you want extra meat?");
        System.out.println("1. Yes\n2. No");
        int extraMeatChoice = getUserChoice();
        sandwich.setExtraMeat(extraMeatChoice == 1);

        // Handle cheese
        System.out.println("Select cheese type (or select 0 for no cheese):");
        System.out.println("1. American\n2. Provolone\n3. Cheddar\n4. Swiss\n0. No Cheese");
        int cheeseChoice = getUserChoice();
        if (cheeseChoice != 0) {
            String cheese = switch (cheeseChoice) {
                case 1 -> "American";
                case 2 -> "Provolone";
                case 3 -> "Cheddar";
                case 4 -> "Swiss";
                default -> "American";
            };
            sandwich.setCheese(cheese);
        }

        // Handle extra cheese
        System.out.println("Do you want extra cheese?");
        System.out.println("1. Yes\n2. No");
        int extraCheeseChoice = getUserChoice();
        sandwich.setExtraCheese(extraCheeseChoice == 1);

        addToppings(sandwich);
        return sandwich;
    }

    public static void addToppings(Sandwich sandwich) {
        System.out.println("Select toppings (press 0 to stop):");
        System.out.println("1. Lettuce\n2. Tomato\n3. Pickles\n4. Onion\n5. Mustard\n6. Mayo\n7. Oil and Vinegar");
        int toppingChoice;
        while ((toppingChoice = getUserChoice()) != 0) { // User will keep getting prompted for toppings choice until they inout 0
            switch (toppingChoice) {
                case 1 -> sandwich.addTopping("Lettuce");
                case 2 -> sandwich.addTopping("Tomato");
                case 3 -> sandwich.addTopping("Pickles");
                case 4 -> sandwich.addTopping("Onion");
                case 5 -> sandwich.addTopping("Mustard");
                case 6 -> sandwich.addTopping("Mayo");
                case 7 -> sandwich.addTopping("Oil and Vinegar");
                default -> System.out.println("Invalid choice.");
            }
            System.out.println("Add another topping or press 0 to stop.");
        }
    }

    public static void addDrink() {
        System.out.println("Select drink size:");
        System.out.println("1. Small\n2. Medium\n3. Large");
        int sizeChoice = getUserChoice();
        String size = switch (sizeChoice) {
            case 1 -> "Small";
            case 2 -> "Medium";
            case 3 -> "Large";
            default -> "Medium";
        };

        System.out.println("Select flavor:");
        System.out.println("1. Cola\n2. Lemonade\n3. Water");
        int flavorChoice = getUserChoice();
        String flavor = switch (flavorChoice) {
            case 1 -> "Cola";
            case 2 -> "Lemonade";
            case 3 -> "Water";
            default -> "Cola";
        };

        Drink drink = new Drink(size, flavor);
        currentOrder.addItem(drink);
        System.out.println("Your drink has been added.");
        displayOrderScreen();
    }

    public static void addChips() {
        System.out.println("Select chip type:");
        System.out.println("1. Plain\n2. Salted\n3. BBQ");
        int chipChoice = getUserChoice();
        String chipType = switch (chipChoice) {
            case 1 -> "Plain";
            case 2 -> "Salted";
            case 3 -> "BBQ";
            default -> "Plain";
        };

        Chips chips = new Chips(chipType);
        currentOrder.addItem(chips);
        System.out.println("Your chips have been added.");
        displayOrderScreen();
    }

    public static void checkout() {
        String receipt = "Your order has been placed!\n" + currentOrder.toString();
        ReceiptManager.saveReceipt(receipt);
        System.out.println(receipt);
    }

    public static void cancelOrder() {
        currentOrder = new Order();
        System.out.println("Your order has been canceled.");
        displayHomeScreen();
    }

    public static int getUserChoice() {
        return scanner.nextInt();
    }
}
