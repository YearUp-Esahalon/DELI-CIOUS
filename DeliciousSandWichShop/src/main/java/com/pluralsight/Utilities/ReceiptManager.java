package com.pluralsight.Utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptManager {

    // Method to save the receipt to a file in the "receipts" directory
    public static void saveReceipt(String receipt) {
        // Ensure the receipts directory exists
        File directory = new File("receipts");
        if (!directory.exists()) {
            directory.mkdir(); // Create the receipts directory if it doesn't exist
        }

        // Generate a unique filename based on the current date and time
        String filename = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";

        // Try writing the receipt to the file
        try (FileWriter writer = new FileWriter(new File(directory, filename))) {
            // Writing receipt format
            writer.write("********** DELI-CIOUS SANDWICH SHOP **********\n");
            writer.write("                Receipt\n");
            writer.write("===============================================\n");
            writer.write("Date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss")) + "\n");
            writer.write("===============================================\n");

            // Add the item details (from the 'receipt' string passed as parameter)
            writer.write(receipt);
            writer.write("\n");

            // Add the total price at the end
            double total = extractTotal(receipt);
            writer.write("===============================================\n");
            writer.write("TOTAL: $" + String.format("%.2f", total) + "\n");
            writer.write("===============================================\n");

            // Optional - Add payment info or thank you message
            writer.write("Thank you for your purchase!\n");
            writer.write("Visit us again at: www.deli-cious.com\n");

            System.out.println("Receipt saved as " + filename); // Inform the user about the saved receipt
        } catch (IOException e) {
            System.out.println("An error occurred while saving the receipt: " + e.getMessage());
        }
    }

    // Method to extract total from the receipt string (for basic formatting)
    private static double extractTotal(String receipt) {
        // Simple way to extract total, assuming the receipt contains "Total: $X.XX"
        String[] lines = receipt.split("\n");
        for (String line : lines) {
            if (line.contains("Total:")) {
                String[] parts = line.split(":");
                String totalStr = parts[1].trim().replace("$", "");
                try {
                    return Double.parseDouble(totalStr);
                } catch (NumberFormatException e) {
                    return 0.0; // Return 0 if total parsing fails
                }
            }
        }
        return 0.0;
    }
}
