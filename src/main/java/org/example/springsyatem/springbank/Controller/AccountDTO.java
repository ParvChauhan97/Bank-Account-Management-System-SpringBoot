package org.example.springsyatem.springbank.Controller;

public class AccountDTO {

    private long accountNumber;
    private String name;
    private double amount;
    private long sender;
    private long receiver;

    public String display() {
        return "Account Number: " + accountNumber + "\n" +
                "Name: " + name + "\n" +
                "Bank Balance: " + amount;
    }


    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setSender(long sender) {
        this.sender = sender;
    }

    public void setReceiver(long receiver) {
        this.receiver = receiver;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public long getSender() {
        return sender;
    }

    public long getReceiver() {
        return receiver;
    }
}
