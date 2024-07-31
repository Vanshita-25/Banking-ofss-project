package com.ofss.main.domain;

import java.sql.Date;

public class Account {

    // variables
    private Date openingDate;
    private double balance;
    private int accountId;
    private String accountStatus;
    private String accountType;
    private Customer customer;

    public Account(Date openingDate, double balance, int accountId, String accountStatus, String accountType,
             Customer customer) {
        this.openingDate = openingDate;
        this.balance = balance;
        this.accountId = accountId;
        this.accountStatus = accountStatus;
        this.accountType = accountType;
        this.customer = customer;
    }

    // constructors
    public Account(){
        System.out.println("This is the default constructor");
    }


    public Account(Customer customer, String accountType) {
        this.customer = customer;
        this.accountType = accountType;
    }

    // getters and setters
    public Date getOpeningDate() { return openingDate; }
    public void setOpeningDate(Date openingDate) { this.openingDate = openingDate;}
    public double getBalance() { return balance;}
    public void setBalance(double balance) {this.balance = balance;}
    public int getAccountId() { return accountId;}
    public void setAccountId(int accountId) { this.accountId = accountId;}
    public String getAccountStatus() {return accountStatus;}
    public void setAccountStatus(String accountStatus) {this.accountStatus = accountStatus;}
    public String getAccountType() { return accountType;}
    public void setAccountType(String accountType) { this.accountType = accountType;}
    public Customer getcustomer() {return customer;}
    public void setcustomer(Customer customer) {this.customer = customer;}
    @Override
    public String toString() {
        return "Account ID = " + accountId + ", Opening Date = " + openingDate + ", Balance = " + balance + 
        ", Account Status = " + accountStatus + ", Account Type = " + accountType  + ", Customer = " + customer;
}

}