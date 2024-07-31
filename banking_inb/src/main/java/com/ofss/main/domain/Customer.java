package com.ofss.main.domain;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {
    private int customerId;
    private String firstName;
    private String lastName;
    private String address1;
    private String address2;
    private String address3;
    private String city;
    private String state;
    private int zip;
    private int phone;
    private int cell;
    private String email;
    private Boolean approvalStatus;
    private Login login;

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    //Constructors
     // Default constructor
     public Customer() {
        System.out.println("Default Constructor for Customer");
     }

     
     public Customer(int customerId, String firstName, String lastName, String address1, String address2,
            String address3, String city, String state, int zip, int phone, int cell, String email,
            Boolean approvalStatus, Login login) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.cell = cell;
        this.email = email;
        this.approvalStatus = approvalStatus;
        this.login = login;
    }

    // Parameterized constructor
     public Customer(String firstName, String lastName, String address1, String address2, String address3, String city, String state, int zip, int phone, int cell, String email, Boolean approvalStatus, Login login) {
        this.firstName = firstName;
         this.lastName = lastName;
         this.address1 = address1;
         this.address2 = address2;
         this.address3 = address3;
         this.city = city;
         this.state = state;
         this.zip = zip;
         this.phone = phone;
         this.cell = cell;
         this.email = email;
         this.approvalStatus = approvalStatus;
         this.login = login;
         System.out.println("Overloaded constructor for Customer");
     }
 


    // Getters and setters
    public int getCustomerId() { return customerId;}
    public void setCustomerId(int customerId) {this.customerId = customerId;}
    public String getFirstName() { return firstName;}
    public void setFirstName(String firstName) { this.firstName = firstName;}
    public String getLastName() { return lastName;}
    public void setLastName(String lastName) { this.lastName = lastName;}
    public String getAddress1() { return address1;}
    public void setAddress1(String address1) { this.address1 = address1;}
    public String getAddress2() {return address2;}
    public void setAddress2(String address2) { this.address2 = address2;}
    public String getAddress3() { return address3;}
    public void setAddress3(String address3) { this.address3 = address3;}
    public String getCity() {return city;}
    public void setCity(String city){this.city = city;}
    public String getState() { return state;}
    public void setState(String state) { this.state = state;}
    public int getZip() { return zip;}
    public void setZip(int zip) { this.zip = zip;}
    public int getPhone() { return phone;}
    public void setPhone(int phone) { this.phone = phone;}
    public int getCell() { return cell;}
    public void setCell(int cell) { this.cell = cell;}
    public String getEmail() { return email;}
    public void setEmail(String email) { this.email = email;}
    public Boolean isApprovalStatus() { return approvalStatus;}
    public void setApprovalStatus(Boolean approvalStatus) {this.approvalStatus = approvalStatus;
    }


    // to String
     // toString() method
     @Override
     public String toString() {
         return "Customer{" + "customerId=" + customerId +", firstName='" + firstName + '\'' +", lastName='" + lastName + '\'' +", address1='" + address1 + '\'' +
                 ", address2='" + address2 + '\'' + ", address3='" + address3 + '\'' + ", city='" + city + '\'' +
                 ", state='" + state + '\'' + ", zip=" + zip + ", phone=" + phone +", cell=" + cell +
                 ", email='" + email + '\'' + ", approvalStatus='" + approvalStatus + '\''+"Login"+ login +'}';
     }
 }
