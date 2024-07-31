package com.ofss.main.domain;

import java.time.Period;

public class Fd {
    private long fdId;
    private Period validity; // Using java.time.Period to represent INTERVAL YEAR TO MONTH
    private double roi; // Using double to represent NUMBER(10)

    // Default constructor
    public Fd() {
        System.out.println("Default constructor for FD");
    }

    // Parameterized constructor
    public Fd(long fdId, Period validity, double roi) {
        this.fdId = fdId;
        this.validity = validity;
        this.roi = roi;
        System.out.println("Overloaded constructor for FD");
    }

    // Getters and setters
    public long getFdId() {return fdId;}
    public void setFdId(long fdId) {this.fdId = fdId;}
    public Period getValidity() {return validity;}
    public void setValidity(Period validity) {this.validity = validity;}
    public double getRoi() {return roi;}
    public void setRoi(double roi) {this.roi = roi;}

    // toString method
    @Override
    public String toString() {
        return "FD{" +"fdId=" + fdId +", validity=" + validity +", roi=" + roi +'}';
    }
}