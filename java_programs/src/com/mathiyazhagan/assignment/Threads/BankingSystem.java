package com.mathiyazhagan.assignment.Threads;

class BankAccount {
    private int accountNumber;
    private double balance;

    public BankAccount(int accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        System.out.println(Thread.currentThread().getName() + " depositing: " + amount);
        balance += amount;
        System.out.println("New balance: " + balance);
    }

    public synchronized void withdraw(double amount) {
        System.out.println(Thread.currentThread().getName() + " withdrawing: " + amount);
        if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            balance -= amount;
            System.out.println("New balance: " + balance);
        }
    }

    public double getBalance() {
        return balance;
    }
}

class TransactionTask implements Runnable {
    private BankAccount account;
    private boolean isDeposit;
    private double amount;

    public TransactionTask(BankAccount account, boolean isDeposit, double amount) {
        this.account = account;
        this.isDeposit = isDeposit;
        this.amount = amount;
    }

    public void run() {
        if (isDeposit) {
            account.deposit(amount);
        } else {
            account.withdraw(amount);
        }
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(101, 1000.0);

        Thread t1 = new Thread(new TransactionTask(account, true, 500.0), "Customer-1");
        Thread t2 = new Thread(new TransactionTask(account, false, 700.0), "Customer-2");
        Thread t3 = new Thread(new TransactionTask(account, true, 300.0), "Customer-3");

        System.out.println("🏦 Starting transactions...");
        t1.start();
        t2.start();
        t3.start();
    }
}