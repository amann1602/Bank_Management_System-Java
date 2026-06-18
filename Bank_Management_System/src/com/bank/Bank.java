package com.bank;

import java.util.ArrayList;

public class Bank {

    ArrayList<Account> accounts = new ArrayList<>();

    // Create Account
    public void createAccount(Account account) {
        accounts.add(account);
        System.out.println("Account Created Successfully.");
    }

    // Search Account
    public Account searchAccount(int accountNo) {

        for (Account acc : accounts) {

            if (acc.getAccountNo() == accountNo) {
                return acc;
            }

        }

        return null;
    }

    // Deposit Money
    public void depositMoney(int accountNo, double amount) {

        Account acc = searchAccount(accountNo);

        if (acc != null) {
            acc.deposit(amount);
        } else {
            System.out.println("Account Not Found!");
        }
    }

    // Withdraw Money
    public void withdrawMoney(int accountNo, double amount) {

        Account acc = searchAccount(accountNo);

        if (acc != null) {
            acc.withdraw(amount);
        } else {
            System.out.println("Account Not Found!");
        }
    }

    // Display Account
    public void displayAccount(int accountNo) {

        Account acc = searchAccount(accountNo);

        if (acc != null) {
            acc.display();
        } else {
            System.out.println("Account Not Found!");
        }
    }
}