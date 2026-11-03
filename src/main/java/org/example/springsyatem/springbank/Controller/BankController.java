package org.example.springsyatem.springbank.Controller;
import org.example.springsyatem.springbank.Service.BankService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class BankController {

    BankService bankservice;
    public BankController(BankService bankservice) {
        this.bankservice = bankservice;
    }

    @PostMapping("/createuser")
    public ResponseEntity<?> createAccount(@RequestBody AccountDTO request) {
            bankservice.createAccount(request.getAccountNumber(), request.getName());
            return ResponseEntity.status(HttpStatus.CREATED).body(request.display());
    }

    @PutMapping("/deposit")
    public ResponseEntity<?> deposit(@RequestBody AccountDTO request) {
        if(true) {
            bankservice.deposit(request.getAccountNumber(), request.getAmount());
            return ResponseEntity.status(HttpStatus.ACCEPTED).
                    body("Deposit Successful\n\n" + "Deposit Amount: " + request.getAmount());
        } return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please Enter Right Information.");
    }

    @PutMapping("/withdraw")
    public ResponseEntity<?> withdraw(@RequestBody AccountDTO request) {
        if(true) {
            bankservice.withdraw(request.getAccountNumber(), request.getAmount());
            return ResponseEntity.status(HttpStatus.ACCEPTED).
                    body("Withdraw Successful\n\n" + "Withdraw Amount: " + request.getAmount());
        } return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Enter Valid Account Number");
    }

    @PutMapping("/transfer")
    public ResponseEntity<?> transfer(@RequestBody AccountDTO request) {
        if(true) {
            bankservice.transfer(request.getSender(), request.getReceiver(), request.getAmount());
            return ResponseEntity.status(HttpStatus.OK).
                    body("Transfer Successful");
        } return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Enter Right Details");
    }

    @GetMapping("/display/{accountNumber}")
    public ResponseEntity<?> display(@PathVariable long accountNumber) {
        return ResponseEntity.ok(bankservice.display(accountNumber));
    }

    @GetMapping("/displayall")
    public ResponseEntity<?> displayAll() {
        return ResponseEntity.ok(bankservice.displayall());
    }
}
