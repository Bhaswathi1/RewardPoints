package com.example.rewardpoints.service;

import com.example.rewardpoints.model.Transaction;

import java.util.List;

public interface TransactionService {

    Transaction getById(Long id);
    List<Transaction> getAll();
    List<Transaction> getByCustomerId(Long customerId);
    void save(Transaction transaction);
    Float getRewardPointsByCustomerId(Long customerId);
}
