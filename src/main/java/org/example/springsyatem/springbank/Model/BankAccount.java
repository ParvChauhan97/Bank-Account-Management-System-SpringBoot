package org.example.springsyatem.springbank.Model;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class BankAccount {
    @Id
    private long accountNumber;
    private String name;
    private double balance;

    @OneToOne(mappedBy = "bankaccount", cascade = CascadeType.ALL)
    private Profile profile;

    public BankAccount() {
    }

    public BankAccount(long accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
        System.out.println("BankAccount Create Successful");
    }

    public String display() {
        return "Name: " + name +"\n" +
                "Account Number: " + accountNumber +"\n" +
                "Balance: " + balance;
    }

    public  void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
            balance -= amount;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
