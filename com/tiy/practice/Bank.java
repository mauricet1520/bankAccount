package com.tiy.practice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by crci1 on 12/6/2016.
 */
public class Bank {
    private String name;

    public ArrayList<BankAccount> getListAccounts() {
        return listAccounts;
    }

    public void setListAccounts(ArrayList<BankAccount> listAccounts) {
        this.listAccounts = listAccounts;
    }

    public ArrayList<BankAccount> listAccounts = new ArrayList<>();
    private ArrayList<String> arrayOfAccounts = new ArrayList<>();
    BankAccount account;
    double totalAmount;
    DateTimeFormatter localFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
//    HashMap<String,ArrayList<BankAccount>> hashAccount= new HashMap<>();





    public void addBankAccount(String name, String bankType, double amount, LocalDateTime localDateTime){
        BankAccount bankAccount = new BankAccount();
        bankAccount.setName(name);
        bankAccount.setBankType(bankType);
        bankAccount.setCurrentAmount(amount);
        bankAccount.setCreatedDate(localDateTime);
        listAccounts.add(bankAccount);





//        hashAccount.put(name,listAccounts);
//        bankAccounts.add(new BankAccount());
//
//        arrayOfAccounts.add("Checking");
//        arrayOfAccounts.add("Savings");
//
//
//
//        account = new BankAccount();
//
//        bankAccounts.add(account);

    }

    public void printInfo(){

        for (BankAccount bankAccount: listAccounts
             ) {
            System.out.println("Bank Info");
            System.out.println("Name: " +bankAccount.getName());
            System.out.println("Type: " +bankAccount.getBankType());
            System.out.println("Balance: $" + bankAccount.getCurrentAmount());
            System.out.println();

        }

//        System.out.println(account.getName());
//        System.out.println("Current balance: $" + account.getBalance());
//        System.out.println("Date: " + localFormat.format(account.getCreatedDate()));
//        System.out.println("Last Transaction: " + localFormat.format(account.getLastTransaction()));
    }

    public double getTotalFromAllAccounts(){

        return 0.0;
    }

}
