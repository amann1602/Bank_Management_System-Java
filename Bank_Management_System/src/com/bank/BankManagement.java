package com.bank;

import java.util.Scanner;

public class BankManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Bank bank = new Bank();

        int choice;

        do {

            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. View Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter Choice : ");

            choice = sc.nextInt();

            switch (choice) {

            case 1:

                System.out.print("Enter Account Number : ");
                int accNo = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter Account Holder Name : ");
                String name = sc.nextLine();

                System.out.print("Enter Initial Balance : ");
                double balance = sc.nextDouble();

                Account account = new Account(accNo, name, balance);

                bank.createAccount(account);

                break;

            case 2:

                System.out.print("Enter Account Number : ");
                int depAcc = sc.nextInt();

                System.out.print("Enter Amount : ");
                double depAmt = sc.nextDouble();

                bank.depositMoney(depAcc, depAmt);

                break;

            case 3:

                System.out.print("Enter Account Number : ");
                int withAcc = sc.nextInt();

                System.out.print("Enter Amount : ");
                double withAmt = sc.nextDouble();

                bank.withdrawMoney(withAcc, withAmt);

                break;

            case 4:

                System.out.print("Enter Account Number : ");
                int balAcc = sc.nextInt();

                Account acc = bank.searchAccount(balAcc);

                if (acc != null) {
                    System.out.println("Current Balance : " + acc.getBalance());
                } else {
                    System.out.println("Account Not Found!");
                }

                break;

            case 5:

                System.out.print("Enter Account Number : ");
                int viewAcc = sc.nextInt();

                bank.displayAccount(viewAcc);

                break;

            case 6:

                System.out.println("Thank You!");

                break;

            default:

                System.out.println("Invalid Choice!");

            }

        } while (choice != 6);

        sc.close();

    }
}