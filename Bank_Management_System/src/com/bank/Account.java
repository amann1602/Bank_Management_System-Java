package com.bank;

public class Account {

    private int accountNo;
    private String name;
    private double balance;

    // Constructor
    public Account(int accountNo, String name, double balance) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
    }

    // Getter
    public int getAccountNo() {
        return accountNo;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit Method
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Amount Deposited Successfully.");
    }

    // Withdraw Method
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Amount Withdrawn Successfully.");
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    // Display Details
    public void display() {
        System.out.println("----------------------------");
        System.out.println("Account Number : " + accountNo);
        System.out.println("Account Holder : " + name);
        System.out.println("Balance        : " + balance);
        System.out.println("----------------------------");
    }
}