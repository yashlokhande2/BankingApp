package com.example.banking.controllers;

import com.example.banking.models.Transaction;
import com.example.banking.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired    
    private TransactionRepository transactionRepository;

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        transaction.setStatus("PENDING");
        return transactionRepository.save(transaction);
    }

    @GetMapping("/user/{userId}")
    public List<Transaction> getTransactionsByUser(@PathVariable Long userId) {
        return transactionRepository.findByUserId(userId);
    }
}
     