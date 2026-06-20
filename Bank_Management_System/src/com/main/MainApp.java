package com.main;

import java.util.Scanner;

import com.dao.AccountDAO;
import com.entity.Account;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AccountDAO dao = new AccountDAO();

        while (true) {

            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1.Create Account");
            System.out.println("2.View Accounts");
            System.out.println("3.Search Account");
            System.out.println("4.Deposit");
            System.out.println("5.Withdraw");
            System.out.println("6.Delete Account");
            System.out.println("7.Exit");

            System.out.print("Enter Choice : ");
            int ch = sc.nextInt();

            switch (ch) {

            case 1:

                System.out.print("Account No : ");
                int no = sc.nextInt();

                sc.nextLine();

                System.out.print("Name : ");
                String name = sc.nextLine();

                System.out.print("Balance : ");
                double bal = sc.nextDouble();

                Account a = new Account(no, name, bal);

                dao.createAccount(a);

                break;

            case 2:
                dao.viewAccounts();
                break;

            case 3:

                System.out.print("Enter Account Number : ");
                dao.searchAccount(sc.nextInt());
                break;

            case 4:

                System.out.print("Account Number : ");
                int acc1 = sc.nextInt();

                System.out.print("Amount : ");
                double amt1 = sc.nextDouble();

                dao.deposit(acc1, amt1);

                break;

            case 5:

                System.out.print("Account Number : ");
                int acc2 = sc.nextInt();

                System.out.print("Amount : ");
                double amt2 = sc.nextDouble();

                dao.withdraw(acc2, amt2);

                break;

            case 6:

                System.out.print("Account Number : ");
                dao.deleteAccount(sc.nextInt());

                break;

            case 7:
                System.exit(0);

            default:
                System.out.println("Invalid Choice");
            }

        }

    }

}