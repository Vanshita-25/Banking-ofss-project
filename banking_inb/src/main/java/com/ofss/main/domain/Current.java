package com.ofss.main.domain;

import java.sql.Date;

public class Current extends Account {

    private double overdraft_bal;
    private double remOverdraft_bal;
    private double minBalance;

    public Current(){
        System.out.println("Default constructor for Current");
    }
    public Current(Date openingDate, double balance, int accountId, String accountStatus, String accountType,
            Customer customer, double overdraft_bal, double remOverdraft_bal, double minBalance) {
        super(openingDate, balance, accountId, accountStatus, accountType, customer);
        this.overdraft_bal = overdraft_bal;
        this.remOverdraft_bal = remOverdraft_bal;
        this.minBalance = minBalance;
        System.out.println("Overloaded constructor for Current");
    }
    public Current(Customer customer, String accountType) {
        super(customer, accountType);
    }

    public double getOverdraft_bal() {
        return overdraft_bal;
    }
    public void setOverdraft_bal(double overdraft_bal) {
        this.overdraft_bal = overdraft_bal;
    }
    public double getRemOverdraft_bal() {
        return remOverdraft_bal;
    }
    public void setRemOverdraft_bal(double remOverdraft_bal) {
        this.remOverdraft_bal = remOverdraft_bal;
    }
    public double getMinBalance() {
        return minBalance;
    }
    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }
    @Override
    public String toString() {
        return "Current [overdraft_bal=" + overdraft_bal + ", remOverdraft_bal=" + remOverdraft_bal + ", minBalance="
                + minBalance + ", getOpeningDate()=" + getOpeningDate() + ", getBalance()=" + getBalance()
                + ", getAccountId()=" + getAccountId() + ", getAccountStatus()=" + getAccountStatus()
                + ", getAccountType()=" + getAccountType() + "]";
    }


}
