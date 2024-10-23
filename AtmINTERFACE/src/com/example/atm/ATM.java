package com.example.atm;

import java.util.Scanner;

public class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        int option = -1;
        while (option != 4) {
            System.out.println("\n************ ATM Menu ************");
            System.out.println("*                                *");
            System.out.println("*   1. Check Balance             *");
            System.out.println("*   2. Deposit                   *");
            System.out.println("*   3. Withdraw                  *");
            System.out.println("*   4. Exit                      *");
            System.out.println("*                                *");
            System.out.println("**********************************");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Exiting ATM. Thank you for using our services.");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }


    private void checkBalance() {
        System.out.println("Your current balance is: $" + account.checkBalance());
    }

    private void deposit() {
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    private void withdraw() {
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }
}
