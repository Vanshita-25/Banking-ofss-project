package com.ofss.main.domain;

import java.sql.Date;

public class Savings extends Account{
    
    private double roi;
    private double minBalance;
    
    //getter and setter
    public double getRoi() {
        return roi;
    }
    public void setRoi(double roi) {
        this.roi = roi;
    }
    public double getMinBalance() {
        return minBalance;
    }
    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    // constructors
    public Savings(Date openingDate, double balance, int accountId, String accountStatus, String accountType,
            Customer customer, double roi, double minBalance) {
        super(openingDate, balance, accountId, accountStatus, accountType, customer);
        this.roi = roi;
        this.minBalance = minBalance;
        System.out.println("Overloaded constructor for Savings");
    } 
    public Savings(Customer customer, String accountType) {
        super(customer, accountType);
    }

    public Savings(){
            System.out.println("Default constructor for Savings");
    }
    @Override
    public String toString() {
        return "Savings [roi=" + roi + ", minBalance=" + minBalance + ", getOpeningDate()=" + getOpeningDate()
                + ", getBalance()=" + getBalance() + ", getAccountId()=" + getAccountId() + ", getAccountStatus()="
                + getAccountStatus() + ", getAccountType()=" + getAccountType() + ", getcustomer()=" + getcustomer()
                + "]";
    }
    
    

}
