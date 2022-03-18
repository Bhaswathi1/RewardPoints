package com.example.rewardpoints.controller;

import com.example.rewardpoints.model.Transaction;
import com.example.rewardpoints.service.TransactionService;
import com.example.rewardpoints.service.RewardPointsCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @Autowired
    RewardPointsCalculatorService rewardPointsCalculatorService;

    @GetMapping("/")
    public List<Transaction> getAllTransactions(){
        return transactionService.getAll();
    }

    @GetMapping("/customer-id/{customerId}")
    public List<Transaction> getTransactionsbyCustomerId(@PathVariable Long customerId){
        return transactionService.getByCustomerId(customerId);
    }

    @GetMapping("/get-reward-points")
    public Float getRewardPointsByAmount(@RequestParam Float amount){
        return rewardPointsCalculatorService.calculateRewardPoints(amount);
    }


    @GetMapping("/get-reward-points-by-customer-id/{customerId}")
    public Float getRewardPointsByCustomerId(@PathVariable Long customerId){
        return transactionService.getRewardPointsByCustomerId(customerId);
    }


    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable Long id){
        return transactionService.getById(id);
    }

    @PostMapping("/")
    public void saveTransaction(Transaction transaction){
        transactionService.save(transaction);
    }


}
