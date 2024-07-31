package com.ofss.main.domain;

public class Login {
    private int loginId;
    private String password;
    private int attempts;
    private String loginStatus;
    

    // Default constructor
    public Login() {
        System.out.println("Default Constructor for Login");
    }

    // Parameterized constructor
    public Login(int loginId, String password, int attempts, String loginStatus) {
        this.loginId = loginId;
        this.password = password;
        this.attempts = attempts;
        this.loginStatus = loginStatus;
        System.out.println("Overloaded Constructor for Login");
    }

    public Login(int loginId, String password){
        this.loginId = loginId;
        this.password = password;
    }
    public Login(String password){
        this.password= password;
    }

    // Getters and setters
    public int getLoginId() { return loginId;}
    public void setLoginId(int loginId) { this.loginId = loginId;}
    public String getPassword() {  return password;}
    public void setPassword(String password) { this.password = password;}
    public int getAttempts() { return attempts;}
    public void setAttempts(int attempts) { this.attempts = attempts;}
    public String getLoginStatus() {return loginStatus;}
    public void setLoginStatus(String loginStatus) { this.loginStatus = loginStatus;}

    // toString() method
    @Override
    public String toString() {
        return "Login{" + "Login Id= " + loginId + "\'" + ", password=" + password + "\'" + ", attempts=" + attempts +
                ", loginStatus=" + loginStatus + " }";
    }
}