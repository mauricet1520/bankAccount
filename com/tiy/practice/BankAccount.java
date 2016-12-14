package com.tiy.practice;

import java.time.LocalDateTime;

public class BankAccount {
    LocalDateTime now = LocalDateTime.now();
    private double currentAmount;
    private String name;
    private LocalDateTime createdDate;
    private LocalDateTime lastTransaction;
    private String bankType;

    public BankAccount() {
        createdDate = LocalDateTime.now();


    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public double getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(double currentAmount) {
        this.currentAmount = currentAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
//        this.createdDate = createdDate;
    }

    public LocalDateTime getLastTransaction() {
        return lastTransaction;
    }

    public void setLastTransaction(LocalDateTime lastTransaction) {

        this.lastTransaction = lastTransaction;
    }


    public double getBalance() {
        return currentAmount;
    }

    public void printInfo() {
        System.out.println("Account Info");
        System.out.println("Name: " + getName());
        System.out.println("Money: " + getCurrentAmount());
        System.out.println("Date: " + getCreatedDate());
        System.out.println("TransDate: " + getLastTransaction());

    }

    public double withdraw(double minusMoney) {
        this.currentAmount -= minusMoney;

        return currentAmount;
    }

    public double deposit(double plusMoney) {

        this.currentAmount += plusMoney;
        return currentAmount;

    }


}
