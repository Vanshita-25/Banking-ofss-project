package com.ofss.main.domain;
import java.sql.Timestamp;

public class Transactions {
    private Timestamp transactionTime;
    private int transactionId;
    private String type;
    private Account account;
    private int recepientAccId;
    private String transactionStatus;
    private double amount;

    // Default constructor
    public Transactions() {
        System.out.println("Default constructor in Transactions");
    }

    // Parameterized constructor
    public Transactions(Timestamp transactionTime, String type, Account account, int recepientAccId, String transactionStatus, double amount) {
        this.transactionTime = transactionTime;
        this.type = type;
        this.account = account;
        this.recepientAccId = recepientAccId;
        this.transactionStatus = transactionStatus;
        this.amount = amount;
        System.out.println("This is overloaded constructor");
    }

    // Getters
    public Timestamp getTransactionTime() { return transactionTime; }
    public int getTransactionId() {  return transactionId;}
    public String getType() { return type;  }
    public Account getaccount() {return account;}
    public int getRecepientAccId() {  return recepientAccId;}
    public String getTransactionStatus() {    return transactionStatus;}
    public double getAmount() { return amount;}

    // Setters
    public void setTransactionTime(Timestamp transactionTime) {this.transactionTime = transactionTime; }
    public void setTransactionId(int transactionId) {this.transactionId = transactionId;}
    public void setType(String type) {this.type = type;  }
    public void setaccount(Account account) {    this.account = account;}
    public void setRecepientAccId(int recepientAccId) { this.recepientAccId = recepientAccId; }
    public void setTransactionStatus(String transactionStatus) {this.transactionStatus = transactionStatus;}
    public void setAmount(double amount) {this.amount = amount;}

    // toString method
    @Override
    public String toString() {
        return "Transaction ID = " + transactionId + ", Transaction Time = " + transactionTime + ", Type = " + type + 
               ", Account = " + account + ", Recepient Account ID = " + recepientAccId + ", Transaction Status = " + transactionStatus + 
               ", Amount = " + amount;
    }
}