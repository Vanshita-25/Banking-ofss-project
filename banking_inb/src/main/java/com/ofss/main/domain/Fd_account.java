package com.ofss.main.domain;

import java.sql.Date;

public class Fd_account {
        private long accountId;
        private long fdAccId;
        private long fdId;
        private Date startDate;
        private Date maturityDate;
        private double investment; // Using double to represent NUMBER(10)
        private double currAmt; // Using double to represent NUMBER(10)
    
        // Default constructor
        public Fd_account() {
            System.out.println("Default constructor for Fd Account");
        }
    
        // Parameterized constructor
        public Fd_account(long accountId, long fdAccId, long fdId, Date startDate, Date maturityDate, double investment, double currAmt) {
            this.accountId = accountId;
            this.fdAccId = fdAccId;
            this.fdId = fdId;
            this.startDate = startDate;
            this.maturityDate = maturityDate;
            this.investment = investment;
            this.currAmt = currAmt;
            System.out.println("Overloaded constructor for Fd Account");
        }
    
        // Getters and setters
        public long getAccountId() {return accountId;}
        public void setAccountId(long accountId) {this.accountId = accountId;}
        public long getFdAccId() { return fdAccId;}
        public void setFdAccId(long fdAccId) { this.fdAccId = fdAccId;}
        public long getFdId() { return fdId;}
        public void setFdId(long fdId) {this.fdId = fdId;}
        public Date getStartDate() {return startDate;}
        public void setStartDate(Date startDate) { this.startDate = startDate;}
        public Date getMaturityDate() { return maturityDate;}
        public void setMaturityDate(Date maturityDate) {this.maturityDate = maturityDate;}
        public double getInvestment() { return investment;}
        public void setInvestment(double investment) {this.investment = investment;}
        public double getCurrAmt() { return currAmt;}
        public void setCurrAmt(double currAmt) { this.currAmt = currAmt;}
    
        // toString method
        @Override
        public String toString() {
            return "FDACCOUNT{" +"accountId=" + accountId +", fdAccId=" + fdAccId + ", fdId=" + fdId +
                    ", startDate=" + startDate +", maturityDate=" + maturityDate +", investment=" + investment +", currAmt=" + currAmt +'}';
        }
}
