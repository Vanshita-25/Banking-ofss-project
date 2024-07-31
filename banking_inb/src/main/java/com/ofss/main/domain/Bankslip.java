package com.ofss.main.domain;

import java.sql.Date;

public class Bankslip {
        private Date slipDate;
        private long accountId;
        private long chequeNo;
        private String chequeStatus;
    
        // Default constructor
        public Bankslip() {
            System.out.println("Default constructor for bankslip");
        }
    
        // Parameterized constructor
        public Bankslip(Date slipDate, long accountId, long chequeNo, String chequeStatus) {
            this.slipDate = slipDate;
            this.accountId = accountId;
            this.chequeNo = chequeNo;
            this.chequeStatus = chequeStatus;
            System.out.println("Overloaded constructor for bankslip");
        }
    
        // Getters and setters
        public Date getSlipDate() {return slipDate;}
        public void setSlipDate(Date slipDate) {this.slipDate = slipDate;}
        public long getAccountId() { return accountId; }
        public void setAccountId(long accountId) {this.accountId = accountId;}
        public long getChequeNo() {return chequeNo;}
        public void setChequeNo(long chequeNo) {this.chequeNo = chequeNo;}
        public String getChequeStatus() {return chequeStatus;}
        public void setChequeStatus(String chequeStatus) {this.chequeStatus = chequeStatus;}
    
        // toString method
        @Override
        public String toString() {
            return "BankSlip{" +"slipDate=" + slipDate + ", accountId=" + accountId + ", chequeNo=" + chequeNo +
                    ", chequeStatus='" + chequeStatus + '\'' +'}';
        }
    }

