package com;

import java.math.BigDecimal;
import java.util.Scanner;

public class CurrencyConverterApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();
        String choice;

        // Menu avec design avancé
        do {
            System.out.println("*************************************************");
            System.out.println("**                                             **");
            System.out.println("**           CURRENCY CONVERTER MENU           **");
            System.out.println("**                                             **");
            System.out.println("*************************************************");
            System.out.println("** 1. Convert currency                         **");
            System.out.println("** 2. Quit                                     **");
            System.out.println("*************************************************");
            System.out.print("Choose an option (1 or 2): ");
            choice = scanner.next();

            switch (choice) {
                case "1":
                    try {
                        // Step 1: Get user input for base currency and target currency
                        System.out.println("*************************************************");
                        System.out.print("Enter the base currency (e.g., USD): ");
                        String baseCurrency = scanner.next().toUpperCase();

                        System.out.print("Enter the target currency (e.g., EUR): ");
                        String targetCurrency = scanner.next().toUpperCase();

                        // Step 2: Fetch the real-time exchange rate
                        BigDecimal exchangeRate = converter.fetchExchangeRate(baseCurrency, targetCurrency);
                        System.out.println("Exchange rate from " + baseCurrency + " to " + targetCurrency + " is: " + exchangeRate);

                        // Step 3: Get the amount to convert
                        System.out.print("Enter the amount you want to convert: ");
                        BigDecimal amount = scanner.nextBigDecimal();

                        // Step 4: Perform the currency conversion
                        BigDecimal convertedAmount = amount.multiply(exchangeRate);
                        System.out.println("*************************************************");
                        System.out.println(amount + " " + baseCurrency + " = " + convertedAmount + " " + targetCurrency);
                        System.out.println("*************************************************");

                    } catch (Exception e) {
                        System.out.println("Error fetching exchange rate: " + e.getMessage());
                    }
                    break;
                case "2":
                    System.out.println("*************************************************");
                    System.out.println("**           Thank you for using our           **");
                    System.out.println("**          Currency Converter Service!        **");
                    System.out.println("*************************************************");
                    break;
                default:
                    System.out.println("Invalid option, please choose 1 or 2.");
            }
        } while (!choice.equals("2"));

        // Fermeture du scanner
        scanner.close();
    }
}
