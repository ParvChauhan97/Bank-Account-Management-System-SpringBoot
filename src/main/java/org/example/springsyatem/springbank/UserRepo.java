package org.example.springsyatem.springbank;

import org.example.springsyatem.springbank.Model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<BankAccount, Long> {

}
