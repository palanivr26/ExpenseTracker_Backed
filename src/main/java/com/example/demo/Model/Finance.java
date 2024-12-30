package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Finance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String month;
    private double paycheck;
    private double sideHustle;
    private double giving;
    private double rent;
    private double utilities;
    private double groceries;
    private double funMoney;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getPaycheck() {
        return paycheck;
    }

    public void setPaycheck(double paycheck) {
        this.paycheck = paycheck;
    }

    public double getSideHustle() {
        return sideHustle;
    }

    public void setSideHustle(double sideHustle) {
        this.sideHustle = sideHustle;
    }

    public double getGiving() {
        return giving;
    }

    public void setGiving(double giving) {
        this.giving = giving;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public double getUtilities() {
        return utilities;
    }

    public void setUtilities(double utilities) {
        this.utilities = utilities;
    }

    public double getGroceries() {
        return groceries;
    }

    public void setGroceries(double groceries) {
        this.groceries = groceries;
    }

    public double getFunMoney() {
        return funMoney;
    }

    public void setFunMoney(double funMoney) {
        this.funMoney = funMoney;
    }
}
