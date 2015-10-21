package com.epsi.soap;

public class Customer {
    private String login;
    private String password;
    private double balance;

    public Customer(String login, String password, double balance) {
        this.login = login;
        this.password = password;
        this.balance = balance;
    }

    public Customer(String login, String password) {
        this.login = login;
        this.password = password;
        this.balance = 0;
    }

    public String getLogin() {
        return login;
    }
    x²
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isValid(){
        return this.login == this.password && this.login != null && this.login.length() > 0;
    }

    public boolean isAdmin(){
        return this.isValid() && this.login == Constante.CUSTOMER_ADMIN;
    }
}