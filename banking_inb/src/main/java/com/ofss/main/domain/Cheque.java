package com.ofss.main.domain;

import java.sql.Date;

public class Cheque {
    private int chequeNo;
    private Date chequeDate;
    private Account account;
    private double amount;
    private int recepientAccId;

    // Default constructor
    public Cheque() {
        System.out.println("Default constructor for Cheque");
    }

    // Parameterized constructor
    public Cheque(int chequeNo, Date chequeDate, Account account, double amount, int recepientAccId) {
        this.chequeNo = chequeNo;
        this.chequeDate = chequeDate;
        this.account = account;
        this.amount = amount;
        this.recepientAccId = recepientAccId;
        System.out.println("Overloaded constructor for Cheque");
    }

    // Getters
    public int getChequeNo() { return chequeNo;}
    public Date getChequeDate(){return chequeDate;}
    public Account getAccount() { return account;}
    public double getAmount() {  return amount;}
    public int getRecepientAccId() {return recepientAccId;}

    // Setters
    public void setChequeNo(int chequeNo) {this.chequeNo = chequeNo; }
    public void setChequeDate(Date chequeDate) {this.chequeDate = chequeDate;}
    public void setAccount(Account account) {     this.account = account;}
    public void setAmount(double amount) {this.amount = amount;}
    public void setRecepientAccId(int recepientAccId) {this.recepientAccId = recepientAccId;}

    // toString method
    @Override
    public String toString() {
        return "Cheque No = " + chequeNo + ", Cheque Date = " + chequeDate + ", Account  = " + account + 
               ", Amount = " + amount + ", Recepient Account ID = " + recepientAccId;
    }
}