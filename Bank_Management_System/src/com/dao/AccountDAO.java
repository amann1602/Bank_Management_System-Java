package com.dao;

import java.sql.*;
import com.db.DBConnection;
import com.entity.Account;

public class AccountDAO {

    Connection con = DBConnection.getConnection();

    // Create Account
    public void createAccount(Account a) {

        try {

            String sql = "insert into account values(?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, a.getAccno());
            ps.setString(2, a.getName());
            ps.setDouble(3, a.getBalance());

            int i = ps.executeUpdate();

            if (i > 0)
                System.out.println("Account Created Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // View All Accounts
    public void viewAccounts() {

        try {

            String sql = "select * from account";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("-------------------");
                System.out.println("Account No : " + rs.getInt(1));
                System.out.println("Name       : " + rs.getString(2));
                System.out.println("Balance    : " + rs.getDouble(3));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Deposit
    public void deposit(int accno, double amount) {

        try {

            String sql = "update account set balance=balance+? where accno=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDouble(1, amount);
            ps.setInt(2, accno);

            int i = ps.executeUpdate();

            if (i > 0)
                System.out.println("Money Deposited Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Withdraw
    public void withdraw(int accno, double amount) {

        try {

            String sql = "update account set balance=balance-? where accno=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDouble(1, amount);
            ps.setInt(2, accno);

            int i = ps.executeUpdate();

            if (i > 0)
                System.out.println("Money Withdrawn Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Search Account
    public void searchAccount(int accno) {

        try {

            String sql = "select * from account where accno=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, accno);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("Account No : " + rs.getInt(1));
                System.out.println("Name       : " + rs.getString(2));
                System.out.println("Balance    : " + rs.getDouble(3));
            } else {
                System.out.println("Account Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Delete Account
    public void deleteAccount(int accno) {

        try {

            String sql = "delete from account where accno=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, accno);

            int i = ps.executeUpdate();

            if (i > 0)
                System.out.println("Account Deleted Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}