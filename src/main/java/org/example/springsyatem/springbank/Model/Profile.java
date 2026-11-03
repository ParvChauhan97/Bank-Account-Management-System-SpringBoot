package org.example.springsyatem.springbank.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Profile {
    @Id
    @JoinColumn(name = "user_id")
    private int id;

    @OneToOne()
    private BankAccount bankaccount;
}
