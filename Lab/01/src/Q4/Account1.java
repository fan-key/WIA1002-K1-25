package Q4;

import java.sql.Date;
import java.util.ArrayList;

public class Account1 {
    ArrayList<Transaction> transactions = new ArrayList<>();
    private String name;
    private int id = 0;
    private double balance = 0;
    private double annualInterestRate = 0;
    private Date dateCreated;

    public Account1() {
        dateCreated = new Date(System.currentTimeMillis());
    }

    public Account1(String name, int id, double balance) {
        this.name = name;
        this.id = id;
        this.balance = balance;
        dateCreated = new Date(System.currentTimeMillis());
    }

    public void withdraw(double amount) {
        if(balance < amount){
            System.out.println("Insufficient balance");
            return;
        }
        balance -= amount;
        transactions.add(new Transaction('W', amount, balance, "Withdrawal"));

    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction('D', amount, balance, "Deposit"));
    }

    public double getMonthlyInterestRate() {
        return annualInterestRate / 1200;
    }

    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate();
    }

    public void printTransactions() {
        System.out.println("Transactions: ");
        for (Transaction transaction : transactions) {
            System.out.println(transaction.toString());
        }
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }
    
    @Override
    public String toString() {
        return "Name: " + name + "\nBalance: " + balance + "\nAnnual Interest Rate: " + annualInterestRate + "\nDate Created: " + dateCreated;
    }
}
