package com.mathiyazhagan.assignment.ExceptionHandling;

import java.util.Scanner;

class InvalidAmountException extends Exception {
 public InvalidAmountException(String message) {
     super(message);
 }
}

class InsufficientFundsException extends Exception {
 public InsufficientFundsException(String message) {
     super(message);
 }
}

class BankAccount {
 private int accountNumber;
 private double balance;

 public BankAccount(int accountNumber, double initialBalance) {
     this.accountNumber = accountNumber;
     this.balance = initialBalance;
 }

 public void deposit(double amount) throws InvalidAmountException {
     if (amount <= 0) {
         throw new InvalidAmountException("Deposit amount must be positive.");
     }
     balance += amount;
 }

 public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
     if (amount <= 0) {
         throw new InvalidAmountException("Withdrawal amount must be positive.");
     }
     if (amount > balance) {
         throw new InsufficientFundsException("Insufficient funds in account.");
     }
     balance -= amount;
 }

 public void displayBalance() {
     System.out.printf("Account %d - Current balance: %.2f\n", accountNumber, balance);
 }
}

public class Main {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     System.out.println("🏦 Welcome to the Banking System Simulator!");
     System.out.println("Please enter your account number:");
     int accountNumber = sc.nextInt();

     System.out.println("Enter initial account balance:");
     double initialBalance = sc.nextDouble();

     BankAccount account = new BankAccount(accountNumber, initialBalance);

     try {
         System.out.println("Enter amount to deposit:");
         double depositAmount = sc.nextDouble();
         account.deposit(depositAmount);

         System.out.println("Enter amount to withdraw:");
         double withdrawAmount = sc.nextDouble();
         account.withdraw(withdrawAmount);

     } catch (InvalidAmountException | InsufficientFundsException e) {
         System.out.println("⚠️ Error: " + e.getMessage());
     } finally {
         System.out.println("✅ Transaction completed.");
     }

     account.displayBalance();
     sc.close();
 }
}
