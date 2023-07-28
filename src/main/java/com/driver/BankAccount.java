package com.driver;
import java.util.*;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public BankAccount() {
    }

    public BankAccount(String name, double balance, double minBalance) {
        this.name=name;
        this.balance=balance;
        this.minBalance=minBalance;

    }

    public String generateAccountNumber(int digits, int sum) throws Exception {
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        String ans="";
        int[] res = new int[digits];
        if (sum == 0) {
                if (digits == 1)
                    return "0";
                else
                    throw new Exception("Account Number can not be generated");

            }



        else {

                if (sum > (9 * digits))
                    throw new Exception("Account Number can not be generated");





            // deduct sum by one to account for cases later
            // (There must be 1 left for the most significant
            //  digit)
            sum -= 1;

            // Fill last m-1 digits (from right to left)
            for (int i = digits - 1; i > 0; i--) {
                // If sum is still greater than 9,
                // digit must be 9
                if (sum > 9) {
                    res[i] = 9;
                    sum -= 9;
                }
                else {
                    res[i] = sum;
                    sum = 0;
                }
            }

        }
        ans=Arrays.toString(res);
        return ans;
    }




    public void deposit(double amount) {
        //add amount to balance
        balance+=amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance

          if(balance-amount<minBalance)
            throw new Exception("Insufficient Balance");
          else
              balance=balance-amount;






    }

}