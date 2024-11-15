# Deli-Cious Sandwich Shop

## Project Overview

This project is a Java-based console application that simulates a sandwich ordering system. It allows users to create their own sandwiches, add drinks and chips, and proceed to checkout where they can view the total price. Users can also customize the toppings on their sandwiches and save their order receipts as text files.

### Author:
- **Elan Sahalon**

## Features

### Home Screen
- **New Order**: Start a new sandwich order.
- **Exit**: Exit the application.

### Order Screen
- **Add Sandwich**: Choose the sandwich options such as size, bread, toppings, and whether it's toasted.
- **Add Drink**: Choose a drink size and flavor.
- **Add Chips**: Select the chip type.
- **Checkout**: Review the order details and proceed to payment.
- **Cancel Order**: Cancel the current order and return to the home screen.

### Add Sandwich Screen
- **Select Bread Type**
- **Choose Sandwich Size**
- **Select Toppings**: Add extra toppings for meats, cheese, and sauces.
- **Toasted Option**: Select if the sandwich should be toasted.

### Add Drink Screen
- **Choose Drink Size**
- **Choose Drink Flavor**

### Add Chips Screen
- **Select Chip Type**

### Checkout Screen
- Display order summary and the total price.
- **Confirm Order**: Save the receipt to a file and return to the home screen.
- **Cancel**: Cancel the order and return to the home screen.

## Optional Bonus
- **Signature Sandwiches**: Allow the user to choose from predefined signature sandwiches, such as:
  - **BLT**: White bread, bacon, cheddar, lettuce, tomato, ranch, toasted.
  - **Philly Cheese Steak**: White bread, steak, American cheese, peppers, mayo, toasted.
  - Other signature sandwiches can be added easily by extending the `Sandwich` class.

## Technologies Used
- Java programming language
- File handling for saving receipts
- Object-oriented design with inheritance and polymorphism

