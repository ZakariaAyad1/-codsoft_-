package com.example.atm;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(500.0);

        ATM atm = new ATM(account);

        atm.showMenu();
    }
}
