package org.example.springsyatem.springbank.Service;
import org.example.springsyatem.springbank.Model.BankAccount;
import org.example.springsyatem.springbank.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional; 

@Service
public class BankService {

    UserRepo userrepo;
    public BankService(UserRepo userrepo) {
        this.userrepo = userrepo;
    }

    public BankAccount createAccount(long accountNumber, String name) {
        BankAccount account = new BankAccount();
        account.setAccountNumber(accountNumber);
        account.setName(name);
        return userrepo.save(account);
    }

    public boolean deposit(long accountNumber, double amount) {
        BankAccount account = userrepo.findById(accountNumber).orElse(null);
        if(account != null) {
            account.deposit(amount);
            userrepo.save(account);
            return true;
        }
        return false;
    }

    public boolean withdraw(long accountNumber, double amount) {
       BankAccount account = userrepo.findById(accountNumber).orElse(null);
       if(account != null) {
           if(amount <= account.getBalance()) {
               account.withdraw(amount);
               userrepo.save(account);
               return true;
           }
       }
       return false;
    }

    public boolean transfer(long sender, long receiver, double amount) {
        BankAccount s = userrepo.findById(sender).orElse(null);
        BankAccount r = userrepo.findById(receiver).orElse(null);

        if(s != null && r != null) {
            if(amount <= s.getBalance()) {
                s.withdraw(amount);
                r.deposit(amount);

                userrepo.save(s);
                userrepo.save(r);
                return true;
            }
        }
        return false;
    }

    public Optional<BankAccount> display(long accountNumber) {
        return userrepo.findById(accountNumber);
    }

    public List<BankAccount> displayall(){
        return userrepo.findAll();
    }
}
